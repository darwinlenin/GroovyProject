
def myClosure = {it * it}

println myClosure(2)


def test = {
    a,b -> 
        def apellido = "Apellido: $b"
        def nombre = "Nombre: ${a}"
        "$nombre $apellido"
    
}('Steef', 'Sheen')

println test