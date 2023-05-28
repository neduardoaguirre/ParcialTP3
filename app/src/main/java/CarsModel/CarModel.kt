package CarsModel

class CarModel {
    var model: String = ""
    var year: Int = 0
    var fuel_type: String = ""
    var transmission: String = ""
    var cylinders: String = ""
    var brand: String = ""

    constructor(model:String?,year: Int?, fuel_type: String?, transmission: String?, cylinders: String?, brand: String?){
        this.model = model!!
        this.year = year!!
        this.fuel_type = fuel_type!!
        this.transmission = transmission!!
        this.cylinders = cylinders!!
        this.brand = brand!!
    }

}


