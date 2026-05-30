#Cadena multilinea con ''' o """
my_str = '''hola mundo'''
#Extraer caracteres desde:hasta(no inclusive)
print(my_str[3:6])
#Extrae caracteres desde:hasta:incremento
print(my_str[0:8:2])
#Invertir una cadena
print(my_str[::-1])
#Convierte a mayusculas
print(my_str.upper())
#Convierte a minusculas
print(my_str.lower())
#Elimina caracteres del inicio y final de la cadena; si no se pasa nada, elimina espacios en blanco
print(my_str.strip('h,o'))
#Reemplaza un caracter con otro
print(my_str.replace('o','x'))
#Separa una cadena por el caracter especificado; si no se pasa nada, lo hace por los espacios
print(my_str.split())
#La cadena empieza con el caracter dado
print(my_str.startswith('h'))
#La cadena termina con el caracter dado
print(my_str.endswith('h'))
#Devuelve indice de la primera aparicion del valor dado, -1 si no encuentra
print(my_str.find('mu'))
#Numero de veces que aparece el valor dado
print(my_str.count('a'))
#Devuelve cadena con el primer caracter en mayuscula
print(my_str.capitalize())
#True si todas las letras de la cadena estan en mayusucula
print(my_str.isupper())
#True si todas las letras de la cadena estan en minuscula
print(my_str.islower())
#Devuelve cadena con la primer letra de cada palabra en mayuscula
print(my_str.title())

my_list = ['hello', 'world']
#Une los iterables de una cadena con el separador dado
print('-'.join(my_list))