package ac.id.ubaya.advweek4.view

import ac.id.ubaya.advweek4.R
import ac.id.ubaya.advweek4.model.Student
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtId.text = studenList[position].id
        holder.view.txtId.text = studenList[position].name

        holder.view.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studenList.size
    }
}

