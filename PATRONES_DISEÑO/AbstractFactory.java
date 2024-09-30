from abc import ABC, abstractmethod

# Productos abstractos
class Coche(ABC):
    @abstractmethod
    def arrancar(self) -> str:
        pass

class Moto(ABC):
    @abstractmethod
    def arrancar(self) -> str:
        pass

# Productos concretos: Vehículos eléctricos
class CocheElectrico(Coche):
    def arrancar(self) -> str:
        return "Arrancando coche eléctrico..."

class MotoElectrica(Moto):
    def arrancar(self) -> str:
        return "Arrancando moto eléctrica..."

# Productos concretos: Vehículos de gasolina
class CocheGasolina(Coche):
    def arrancar(self) -> str:
        return "Arrancando coche de gasolina..."

class MotoGasolina(Moto):
    def arrancar(self) -> str:
        return "Arrancando moto de gasolina..."

# Fábrica abstracta
class FabricaVehiculos(ABC):
    @abstractmethod
    def crear_coche(self) -> Coche:
        pass

    @abstractmethod
    def crear_moto(self) -> Moto:
        pass

# Fábricas concretas
class FabricaElectrica(FabricaVehiculos):
    def crear_coche(self) -> Coche:
        return CocheElectrico()
    
    def crear_moto(self) -> Moto:
        return MotoElectrica()

class FabricaGasolina(FabricaVehiculos):
    def crear_coche(self) -> Coche:
        return CocheGasolina()
    
    def crear_moto(self) -> Moto:
        return MotoGasolina()

# Uso
def codigo_cliente(fabrica: FabricaVehiculos):
    coche = fabrica.crear_coche()
    moto = fabrica.crear_moto()

    print(coche.arrancar())
    print(moto.arrancar())

# Crear vehículos eléctricos
print("Vehículos eléctricos:")
codigo_cliente(FabricaElectrica())

# Crear vehículos de gasolina
print("\nVehículos de gasolina:")
codigo_cliente(FabricaGasolina())
