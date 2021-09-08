package ac.id.ubaya.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.ubaya.advweek4.R
import ac.id.ubaya.advweek4.model.Student
import ac.id.ubaya.advweek4.viewmodel.DetailViewModel
import ac.id.ubaya.advweek4.viewmodel.ListViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            var Studentt = viewModel.studentLD.value
            var id = Studentt?.id
            var name = Studentt?.name
            var bod = Studentt?.bod
            var phone = Studentt?.phone
            var photoUrl = Studentt?.photoUrl

            txtId.setText(id)
            txtName.setText(name)
            txtBoD.setText(bod)
            txtPhone.setText(phone)


        })

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel()
    }
}