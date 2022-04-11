package com.example.lesson_18_right

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.lesson_18_right.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "Pahan"
    private var password: String = "Pahan"
    private var name: String = "Pahan"
    private var family: String = "Pahan"
    private var fname: String = "Pahan"
    private var avatarImageID: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.REQUEST_CODE_SIGN_IN) {
val l = data?.getStringExtra(Constance.LOGIN)
val p = data?.getStringExtra(Constance.PASWORD)
            if (login==l && password == p){
                bindingClass.imageView.setImageResource(avatarImageID)
                val textinfo = "$family $name $fname"
                bindingClass.tVinfo.text = textinfo
            }
            else{
                bindingClass.tVinfo.text = Constance.NO_SiGN_IN
                bindingClass.imageView.setImageResource(R.drawable.go_nnnnnnn)
            }
            bindingClass.imageView.visibility = View.VISIBLE
        }
        else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {
            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASWORD)!!
            name= data.getStringExtra(Constance.NAME)!!
            family = data.getStringExtra(Constance.FAMILY)!!
            fname = data.getStringExtra(Constance.FATHER_NAME)!!
            avatarImageID = data.getIntExtra(Constance.AVATAR, 0)
            bindingClass.imageView.setImageResource(avatarImageID)
            val textinfo = "$family $name $fname"
            bindingClass.tVinfo.text = textinfo
            bindingClass.bReg.visibility = View.INVISIBLE
            bindingClass.bExed.text = getString(R.string.Exed)
            bindingClass.imageView.visibility = View.VISIBLE
        }

    }
    fun onclickSignIn(view: View) {
        if (bindingClass.imageView.isVisible && bindingClass.tVinfo.text.toString() != Constance.NO_SiGN_IN) {
            bindingClass.imageView.visibility = View.INVISIBLE
            bindingClass.bReg.visibility = View.VISIBLE
            bindingClass.bExed.text = getString(R.string.vhod)
            bindingClass.tVinfo.text = ""
        } else {
            val intent = Intent(this, VhodActivity::class.java)
            intent.putExtra("${Constance.SIGN_STATE}", Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }
    }

    fun onclickSignUp(view: View) {
        val intent = Intent(this, VhodActivity::class.java)
        intent.putExtra("${Constance.SIGN_STATE}", Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }
}