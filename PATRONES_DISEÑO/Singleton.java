class Singleton:
    _instance = None  # Variable de clase para almacenar la única instancia

    def __new__(cls):
        if cls._instance is None:  # Si no hay instancia, crea una nueva
            cls._instance = super(Singleton, cls).__new__(cls)
            cls._instance.data = None  # Inicializa atributos de la instancia
        return cls._instance

# Uso
singleton1 = Singleton()
singleton2 = Singleton()

singleton1.data = "Singleton Data"

print(singleton1.data)  # Singleton Data
print(singleton2.data)  # Singleton Data

# Verificamos que ambos objetos son la misma instancia
print(singleton1 is singleton2)  # True
