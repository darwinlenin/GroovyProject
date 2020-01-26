import groovy.transform.*
//Canonical = EqualsAndHashCode, ToString, TupleConstructor
@Immutable class Person {
    String nombre
    String apellido
    Date Edad
    String ciudad
}

def a = new Person('Steef', 'Sheen', new Date(), 'Lima')
a.nombre = 'Juan'
println a