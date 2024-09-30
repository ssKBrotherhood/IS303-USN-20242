# Producto: El sándwich que estamos construyendo
class Sandwich:
    def __init__(self):
        self.pan = None
        self.carne = None
        self.lechuga = None
        self.salsa = None

    def __str__(self):
        return f"Sándwich con: {self.pan}, {self.carne}, {self.lechuga}, {self.salsa}"

# Builder: Define cómo construir el sándwich
class SandwichBuilder:
    def __init__(self):
        self.sandwich = Sandwich()

    def agregar_pan(self, tipo_pan):
        self.sandwich.pan = tipo_pan
        return self  # Devolvemos el builder para encadenar métodos

    def agregar_carne(self, tipo_carne):
        self.sandwich.carne = tipo_carne
        return self

    def agregar_lechuga(self):
        self.sandwich.lechuga = "lechuga"
        return self

    def agregar_salsa(self, tipo_salsa):
        self.sandwich.salsa = tipo_salsa
        return self

    def obtener_sandwich(self):
        return self.sandwich

# Director: Controla el proceso de construcción
class Director:
    def __init__(self, builder: SandwichBuilder):
        self.builder = builder

    def preparar_sandwich_completo(self):
        self.builder.agregar_pan("pan integral").agregar_carne("pollo").agregar_lechuga().agregar_salsa("mayonesa")
        return self.builder.obtener_sandwich()

    def preparar_sandwich_simple(self):
        self.builder.agregar_pan("pan blanco").agregar_carne("jamón")
        return self.builder.obtener_sandwich()

# Uso
if __name__ == "__main__":
    # Crear un builder
    builder = SandwichBuilder()
    
    # Director que controla la construcción
    director = Director(builder)

    # Construir un sándwich completo
    sandwich_completo = director.preparar_sandwich_completo()
    print(sandwich_completo)  # Sándwich con: pan integral, pollo, lechuga, mayonesa

    # Construir un sándwich simple
    builder = SandwichBuilder()  # Reiniciar el builder
    director = Director(builder)
    sandwich_simple = director.preparar_sandwich_simple()
    print(sandwich_simple)  # Sándwich con: pan blanco, jamón, None, None
