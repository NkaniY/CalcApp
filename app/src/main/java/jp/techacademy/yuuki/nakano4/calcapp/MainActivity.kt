package jp.techacademy.yuuki.nakano4.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd.setOnClickListener(this)
        buttonSub.setOnClickListener(this)
        buttonMulti.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)
    }

    override fun onClick(v: View){
        var num1 = 0.0
        var num2 = 0.0
        var ans = 0.0
        try {
            num1 = editText1.text.toString().toDouble()
            num2 = editText2.text.toString().toDouble()
        } catch (e:NumberFormatException){
            val mySnackbar = Snackbar.make(rootLayout, "何か数値を入力してください", Snackbar.LENGTH_LONG)
            mySnackbar.show()
            return
        }

        when (v.id){
            R.id.buttonAdd -> {
                ans = num1 + num2
            }
            R.id.buttonSub -> {
                ans = num1 - num2
            }
            R.id.buttonMulti -> {
                ans = num1 * num2
            }
            R.id.buttonDiv -> {
                if(num2 == 0.0){
                    val mySnackbar = Snackbar.make(rootLayout, "0で割ることはできません", Snackbar.LENGTH_LONG)
                    mySnackbar.show()
                    return
                }

                ans = num1 / num2
            }
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1",ans.toString())
        startActivity(intent)
    }
}
