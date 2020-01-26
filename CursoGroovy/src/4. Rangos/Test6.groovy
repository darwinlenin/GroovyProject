Range r = 1..100
println r.step(2)
println r.class.name
println r.from
println r.to

assert (0..10).contains(0)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

assert (0..<10).contains(0)
assert (0..<10).contains(10) == false

Date today = new Date()
Date oneWeekAway = today + 7 //GDK

println today
println oneWeekAway

def days = today..oneWeekAway
println days.step(1)

Range letters = 'a'..'z'
println letters.step(2)


enum Days {
    DOMINGO,LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO
}

def dayRange = Days.DOMINGO..Days.SABADO

dayRange.each { day ->
    println day
}

println dayRange.size()
println dayRange.contains(Days.MIERCOLES)

// Bonus: next() and previous() are equivalent to
// ++ and -- operators.
def miercoles = Days.MIERCOLES
assert Days.JUEVES == ++miercoles
println miercoles
assert Days.MIERCOLES == --miercoles