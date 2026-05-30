print("hola mundo")
print('Mis colores favoritos son', 'azul', 'rosa', 'morado')

int_var = 5
float_var = 5.5
string_var = "hola"
boolean_var = True
set_var = {7,8,6}
dictionary_var = {'name':'Daniela'}
tuple_var = (1,2,3)
range_var = range(5)
list_var = [1,2,3,4,5]
none_var = None

#Tipo de la variable
print(int_var, type(int_var))
#Verifica el tipo de una variable
print(isinstance(set_var, set))
#Longitud de la variable
print(len(string_var))
#El valor se encuentra en una variable
print('ola' in string_var)
#Valor del indice dado
print(string_var[3])

name = 'John'
age = 25
#Solo se concatenan String
print(name + ' tiene ' + str(age) + ' años.')
#utilizando F o f al inicio se pueden concatenar variables de cualqier tipo
print(f'Mi nombre es {name} y tengo {age} años.')

age = 19
is_employed = False

print(age or is_employed) # 19

