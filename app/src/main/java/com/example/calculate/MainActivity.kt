package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculate.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.expressao
        binding.result

        //Números
        binding.btnZero.setOnClickListener { adicionarExpressao("0", true) }
        binding.btnUm.setOnClickListener { adicionarExpressao("1", true) }
        binding.btnDois.setOnClickListener { adicionarExpressao("2", true) }
        binding.btnTres.setOnClickListener { adicionarExpressao("3", true) }
        binding.btnQuatro.setOnClickListener { adicionarExpressao("4", true) }
        binding.btnCinco.setOnClickListener { adicionarExpressao("5", true) }
        binding.btnSeis.setOnClickListener { adicionarExpressao("6", true) }
        binding.btnSete.setOnClickListener { adicionarExpressao("7", true) }
        binding.btnOito.setOnClickListener { adicionarExpressao("8", true) }
        binding.btnNove.setOnClickListener { adicionarExpressao("9", true) }

        //Operadores
        binding.btnSum.setOnClickListener { adicionarExpressao("+", false) }
        binding.btnSubtract.setOnClickListener { adicionarExpressao("-", false) }
        binding.btnMultiply.setOnClickListener { adicionarExpressao("*", false) }
        binding.btnDivide.setOnClickListener { adicionarExpressao("/", false) }

        binding.btnDelete.setOnClickListener {
            binding.expressao.text = ""
            binding.result.text = ""
        }

        binding.btnDot.setOnClickListener { adicionarExpressao(".", false) }

        binding.btnBackspace.setOnClickListener {
            val string = binding.expressao.text.toString()

            if (string.isNotBlank()){
                binding.expressao.text = string.substring(0,string.length-1)
            }
            binding.result.text = ""
        }

        binding.btnEqual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(binding.expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val final_result = resultado.toLong()

                if (resultado == final_result.toDouble()) binding.result.text = final_result.toString()
                else binding.result.text = resultado.toString()
            }
            catch (e : Exception){

            }
        }

    }

    fun adicionarExpressao(calculo: String, limpar_dados: Boolean){
        if (binding.result.text.isNotEmpty()){
            binding.expressao.text = ""
        }
        if (limpar_dados){
            binding.result.text = ""
            binding.expressao.append(calculo)
        } else {
            binding.expressao.append(binding.result.text)
            binding.expressao.append(calculo)
            binding.result.text = ""
        }
    }
}



