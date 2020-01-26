def nums = [1,2,3,6,7,9,4,5,3,6,8,9]
println nums
println nums.class.name

// add | remove | get | clear

nums.push(99)
nums.putAt(0,77)
nums[1] = 78
nums << 66

println nums

nums.pop()
nums.removeAt(0)
def newList = nums + 3
// newList.pop()
println newList
println nums

println nums.getAt(0..3)

nums = []

// // flatten
nums << [3,4,5,5,5]
nums << [1,2]
println nums
nums =  nums.flatten()

// // equals
def myNumbers = [1,2,3]
def myNumbers2 = [1,2,3]
println myNumbers.equals(myNumbers2)

// // findAll
println nums.findAll { it == 4 }
println nums.flatten().findAll { it < 5 }

// // getAt(Range)
println nums.flatten().getAt(0..3)

// // reverse list
println nums.reverse()

// // unique
println nums.unique()

//Join
def joinTest = ['Steef', 'Alexander'].join(' ')
println joinTest

// // Java Collections List(LinkedList) (Set,SortedSet)
def evens = [10,2,8,4,24,14,2,2,3,4,2,1,2] as Set
println evens
println evens.class.name

//inject
def test = [1,2,3,4].inject(0) {
    first, next -> first + next
}

println test


//Collect 

def collectExample  = [4,5,6,7,8].collect(){
    it ** 2
}

println collectExample


// EJERCICIOS

@groovy.transform.Canonical
class Estadio {
    String nombre
    BigDecimal capacidad
    boolean activo
}

def madrid = new Estadio('Santiago Bernabeu', 80000.00, true)
def callao = new Estadio('Telmo Carvajo', 30000.00, false)
def lima = new Estadio('Jose Diaz', 40000.00, true)
def sc = new Estadio('Alberto Gallardo', 15000, true)
def rio = new Estadio('Maracana', 100000.00, false)

def estadios = [madrid,callao,lima,sc,rio]

println estadios


def result = estadios.findAll() {
    it.capacidad > 30000.00 && it.activo
}.collect() {
    it.nombre
}

println result



