// java
String a = "Experis"
char b = 'a'

println a.class 
println b.class

// groovy

def nombre = 'Steef'
def a2 = "Experis $nombre"
a2 = "Experis ${(nombre == 'Steef') ? 'Sheen' : 'Caceres'}"
def b2 = 'a ${nombre}'

println a2
println a2.class 
println b2.class


println """
    Steef Alexander
    Sheen Caceres
    Experis $a2
"""
