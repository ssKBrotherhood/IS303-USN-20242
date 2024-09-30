from abc import ABC, abstractmethod

# Producto abstracto
class Transporte(ABC):
    @abstractmethod
    def entregar(self):
        pass

# Productos concretos
class Camion(Transporte):
    def entregar(self):
        return "Entrega por tierra en un camión."

class Barco(Transporte):
    def entregar(self):
        return "Entrega por mar en un barco."

# Creador abstracto
class Logistica(ABC):
    @abstractmethod
    def crear_transporte(self) -> Transporte:
        pass

    def planificar_entrega(self):
        transporte = self.crear_transporte()
        return transporte.entregar()

# Creadores concretos
class LogisticaTerrestre(Logistica):
    def crear_transporte(self) -> Transporte:
        return Camion()

class LogisticaMaritima(Logistica):
    def crear_transporte(self) -> Transporte:
        return Barco()

# Uso
def codigo_cliente(logistica: Logistica):
    print(logistica.planificar_entrega())

# Planifica una entrega por carretera
codigo_cliente(LogisticaTerrestre())  # Entrega por tierra en un camión.

# Planifica una entrega por mar
codigo_cliente(LogisticaMaritima())   # Entrega por mar en un barco.
