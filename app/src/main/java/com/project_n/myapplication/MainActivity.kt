package com.project_n.myapplication

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project_n.myapplication.Apis.ApiService
import com.project_n.myapplication.Apis.Interface
import com.project_n.myapplication.model.ModelData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog!!.setTitle("Loading ya SABAR .......")
        progressDialog!!.setMessage("SABAR CUUUUUKKKKKK......")
        progressDialog!!.show()

        val apiInterface = ApiService.dataUser!!.create(Interface::class.java)
        val call: Call<List<ModelData>> = apiInterface.user
        call.enqueue(object : Callback<List<ModelData>> {
            override fun onResponse(call: Call<List<ModelData>>, response: Response<List<ModelData>>) {
                try {
                    progressDialog!!.dismiss()
                    val modelDatas = response.body()
                    val i = modelDatas!!.size
                            textView_id.text = "jumlah : "+ i
                            textView_user_name.text = "Nama : " + modelDatas.get(0).nama
                            textView_user_email.text = "Email : " + modelDatas[0].email
                            textView_user_pass.text = "Pass : " + modelDatas.get(1).pass

                } catch (e: Exception) {

                }

            }

            override fun onFailure(call: Call<List<ModelData>>, t: Throwable) {
//                progressDialog!!.dismiss()
            }
        })
    }
}