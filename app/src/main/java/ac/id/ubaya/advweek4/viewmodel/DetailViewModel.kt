package ac.id.ubaya.advweek4.viewmodel

import ac.id.ubaya.advweek4.model.Student
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch(id:String) {
        val student1 = Student(id,"Nonie","1998/03/28","5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }
}