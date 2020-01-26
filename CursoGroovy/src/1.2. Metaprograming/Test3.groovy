class Steef {

}

def a = new Steef ()
a.metaClass.apellido = 'Sheen'
a.metaClass.ciudad = 'Lima'
a.metaClass.imprimeDatos = {
    -> println "Apellido: $apellido - Ciudad: $ciudad"
}

a.imprimeDatos()

a.apellido = 'Caceres'

a.imprimeDatos()