package com.example.calculatorapp

import androidx.lifecycle.ViewModel
class ViewModel:  ViewModel() {

    var output = 0f
    var opr = ' '
    var fNum = ""
    var sNum = ""

    var distext = "0"

    //if the numbers is decimal
    fun onClickDecimal(){
        if(opr==' '&&!fNum.contains(".")){decNum('.')}
        if(opr!=' '&&!sNum.contains(".")){decNum('.')}
    }
    fun decNum(number: Char){
        if(opr==' '){
            fNum += number
            distext = fNum
        }else{
            sNum += number
            val text = fNum + opr + sNum
            distext = text
        }
    }
    //if the numbers has sign
    fun onClickPlusMinus(){
        if(opr==' '){
            fNum = if(fNum.startsWith("-")){
                fNum.substring(1, fNum.length)
            } else{
                "-$fNum"
            }
            distext = fNum
        }else{
            sNum = if(sNum.startsWith("-")){
                sNum.substring(1, sNum.length)
            } else{
                "-$sNum"
            }
            val text = fNum + opr + sNum
            distext = text
        }
    }
    fun handleOperator(op: Char){
        opr = op
        val text = fNum + opr
        distext = text
    }

    fun calculate(){
        var divByZero = false
        when (opr) {
            '+' -> output = fNum.toFloat() + sNum.toFloat()
            '-' -> output = fNum.toFloat() - sNum.toFloat()
            '*' -> output = fNum.toFloat() * sNum.toFloat()
            '/' -> if(fNum.toFloat()!=0f&&sNum.toFloat()!=0f){
                output = fNum.toFloat() / sNum.toFloat()
            }else{
                divByZero = true
            }
        }
        fNum = output.toString()
        sNum = ""
        distext = output.toString()
        if(divByZero){clearAll()}
    }
    fun clearAll(){
        output = 0f
        opr = ' '
        fNum = ""
        sNum = ""
        distext = "0"
    }

    fun deleteLast(){
        if(opr==' '){
            if(fNum.isNotEmpty()){
                fNum = fNum.substring(0, fNum.length - 1)
                if(fNum.isEmpty()){distext = "0"}
                else{distext = fNum}
            }
        }else{
            if(sNum.isNotEmpty()){
                sNum = sNum.substring(0, sNum.length - 1)
                val text = fNum + opr + sNum
                distext = text
            }else{
                opr=' '
                distext = fNum
            }
        }
    }
}