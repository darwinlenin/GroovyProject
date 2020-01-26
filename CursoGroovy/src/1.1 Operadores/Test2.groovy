def a = 1
def b = 10

println a + b
println a.plus(b)
println a.minus(b)

@groovy.transform.Canonical 
class Prueba {
    int numero1
    int numero2
    int plus(Prueba p) {
        this.numero1 + p.numero1
    }
}

def a1 = new Prueba(1,10)
def a2 = new Prueba(20,30)

println a1 + a2