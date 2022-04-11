package com.example.lesson_18_right

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.lesson_18_right.databinding.ActivityVhodBinding

class VhodActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityVhodBinding
    var signState = "empty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityVhodBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
         signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_IN_STATE) {
bindingClass.bAvatar.visibility = View.INVISIBLE
bindingClass.ettpnName.visibility = View.GONE
bindingClass.ettpnFamily.visibility = View.GONE
bindingClass.ettpnOtchestvo.visibility = View.GONE


        }


    }
    fun onClickDone(view: View){
        if (signState == Constance.SIGN_IN_STATE) {
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.ettpnLogin.text.toString())
            intent.putExtra(Constance.PASWORD, bindingClass.ettpnParol.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
        if (signState == Constance.SIGN_UP_STATE) {
val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.ettpnLogin.text.toString())
            intent.putExtra(Constance.PASWORD, bindingClass.ettpnParol.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.ettpnName.text.toString())
            intent.putExtra(Constance.FAMILY, bindingClass.ettpnFamily.text.toString())
            intent.putExtra(Constance.FATHER_NAME, bindingClass.ettpnOtchestvo.text.toString())
            if (bindingClass.imageAvatar.isVisible) {
                intent.putExtra(Constance.AVATAR, R.drawable.programmer)
                setResult(RESULT_OK, intent)
                bindingClass.textmasage.visibility = View.INVISIBLE
                finish()
            }
            else {
                bindingClass.textmasage.visibility = View.VISIBLE
                bindingClass.textmasage.text = "Заполните все поля и выберите фото"
            }
        }
    }

    fun onClickAvatar(view: View){
        bindingClass.imageAvatar.visibility = View.VISIBLE
    }
}