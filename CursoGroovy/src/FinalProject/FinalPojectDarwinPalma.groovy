// ---------------------------
//
// HOMEWORK
//
// You can use either Groovy or Java.
//
// Design a routine that will calculate the average Product price per Group.
//
// The Price of each Product is calculated as:
// Cost * (1 + Margin)
//
// Assume there can be a large number of products and a large number of categories.
//
// Plus points:
// - use Groovy and its closures
// - make the category look-up performance effective
// - use method Collection.inject

// contains information about [Product, Group, Cost]
def products = [
        ["A", "G1", 20.1],
        ["B", "G2", 98.4],
        ["C", "G1", 49.7],
        ["D", "G3", 35.8],
        ["E", "G3", 105.5],
        ["F", "G1", 55.2],
        ["G", "G1", 12.7],
        ["H", "G3", 88.6],
        ["I", "G1", 5.2],
        ["J", "G2", 72.4]]

// contains information about Category classification based on product Cost
// [Category, Cost range from (inclusive), Cost range to (exclusive)]
// i.e. if a Product has Cost between 0 and 25, it belongs to category C1
def category = [
        ["C3", 50, 75],
        ["C4", 75, 100],
        ["C2", 25, 50],
        ["C5", 100, null],
        ["C1", 0, 25]]

// contains information about margins for each product Category
// [Category, Margin (either percentage or absolute value)]
def margins = [
        "C1": "20%",
        "C2": "30%",
        "C3": "0.47",
        "C4": "50%",
        "C5": "0.66"]

// ---------------------------
//
// YOUR CODE GOES BELOW THIS LINE
//
// Assign the 'result' variable so the assertion at the end validates
//
// ---------------------------

//PREVIOUS CALC
//24.12
//64.61
//81.144
//15.24
//6.24       38.2708      38.3
//
//147.6
//106.428    127.014      127.1
//
//46.54
//175.13
//132.9      118.19       118.2

////*** STEP PLAN TO DO ***////
//grouping the group
//consult each cost
//consult range of category
//consult margin
//convert margin
//do operation of calc price
//add a new list of group
//get calc of average for group
//add value with average amount
//apply round function
//compare variable result with final assert condition

//Test initialValues
def result = [:]
//grouping by group
def listGroup = products.groupBy {it[1]}.collect {key,value->value}
//println listGroup
listGroup.each { tupleListGroup ->
    def avgCategory = 0
    def quantityCategory = 0
    tupleListGroup.each { innerTuple ->
        category.each { cat ->
            //validate in case of upper range limit of category is null
            if ((cat.get(2) != null)) {
                if (innerTuple.get(2) >= cat.get(1) && innerTuple.get(2) <= cat.get(2)) {
                    //println "categories "+cat.get(0)
                    def marginPercent
                    if (margins.get(cat.get(0)).contains("%")) {
                        marginPercent = (margins.get(cat.get(0)).replace("%", "").toDouble()) / 100
                    } else {
                        marginPercent = margins.get(cat.get(0))
                    }
                    //println "marginPercent "+marginPercent
                    def price = ((innerTuple.get(2).toString()).toDouble() * (1 + (marginPercent.toString()).toDouble()))
                    avgCategory = avgCategory.plus(price)
                    quantityCategory = quantityCategory.plus(1)
                }
            } else {
                if (innerTuple.get(2) >= cat.get(1)) {
                    //println "categories "+cat.get(0)
                    def marginPercent
                    if (margins.get(cat.get(0)).contains("%")) {
                        marginPercent = (margins.get(cat.get(0)).replace("%", "").toDouble()) / 100
                    } else {
                        marginPercent = margins.get(cat.get(0))
                    }
                    //println "marginPercent "+marginPercent
                    def price = ((innerTuple.get(2).toString()).toDouble() * (1 + (marginPercent.toString()).toDouble()))
                    avgCategory = avgCategory.plus(price)
                    quantityCategory = quantityCategory.plus(1)
                }
            }
        }
    }
    //Getting the average of price
    def avgPrice = avgCategory/quantityCategory
    //println avgPrice
    BigDecimal bg1 = new BigDecimal(avgPrice.toString())
    //println "value of prices "+bg1.setScale(1,BigDecimal.ROUND_UP)
    //println "value of groups "+tuple.get(1).get(1)
    result.put(tupleListGroup.get(1).get(1),bg1.setScale(1,BigDecimal.ROUND_UP))
}

//Final Map Result
println result

// ---------------------------
//
// IF YOUR CODE WORKS, YOU SHOULD GET "It works!" WRITTEN IN THE CONSOLE
//
// ---------------------------
assert result == [
        "G1": 38.3,
        "G2": 127.1,
        "G3": 118.2
]: "It doesn't work"


println "It works!"

/////