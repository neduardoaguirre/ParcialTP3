package CarsModel

data class CarsResponse (
    val results: List<Car>
)

data class Car(
    val make: String,
    val model: String,
    val year: Int,
    val fuel_type: String,
    val transmission: String?,
    val cylinders: Int?
)
