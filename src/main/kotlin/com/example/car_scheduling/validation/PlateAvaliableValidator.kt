//import com.example.car_scheduling.service.CarService
//import com.example.car_scheduling.service.CustomerService
//import com.example.car_scheduling.validation.EmailAvaliable
//import com.example.car_scheduling.validation.PlateAvaliable
//import jakarta.validation.ConstraintValidator
//import jakarta.validation.ConstraintValidatorContext
//
//class PlateAvaliableValidator(
//
//    val service: CarService
//): ConstraintValidator<PlateAvaliable, String>{
//
//
//
//    override fun isValid(value: String?, context: ConstraintValidatorContext?){
//
//        if (value.isNullOrEmpty()) {
//            return false
//        }
//
//        return service.existsByEmailCustomer(value)
//    }