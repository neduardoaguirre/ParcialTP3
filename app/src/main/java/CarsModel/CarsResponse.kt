package CarsModel

class Car {
    var make: String = ""
    var model: String = ""
    var year: Int = 0
    var fuel_type: String = ""
    var transmission: String = ""
    var cylinders: Int = 0

    constructor(make: String, model: String, year: Int, fuel_type: String, transmission: String, cylinders: Int) {
        this.make = make!!
        this.model = model!!
        this.year = year!!
        this.fuel_type = fuel_type!!
        this.transmission = transmission!!
        this.cylinders = cylinders!!
    }
}


class SerializableListCars : java.io.Serializable {
    var listCars: List<Car> = ArrayList<Car>()

    constructor(list: List<Car>) {
        this.listCars = list
    }
}
