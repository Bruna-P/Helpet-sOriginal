package pad.time3.helpet_s5

import android.content.Intent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        idRegister.setOnClickListener {
           salvarAluno()
            val intent = Intent(this, Info2::class.java)
            startActivity(intent)
        }
    }

    //Declaração da função salvarAluno(), que permite salvar um objeto aluno no banco de dados do firebase firestore
    private fun salvarAluno(){

        //Função verifyInputs(), permite verificar se os dados digitados pelo usuário são válidos
       // var isValid: Boolean = verifyInputs()

       //Se o retorno da função verifyInputs()foi com sucesso, o código executará o bloco a seguir:
     //   if (isValid) {

            //criação de um identificador para o aluno que será usado como id do documento do banco
            val id = txtGmail.text.toString()

            //criação de um objeto do tipo Aluno
            val usuario = Usuario(
                id, txtlogin.text.toString()

            )

            //função para testar se há conexão com a internet
            if (Util.isDeviceConnected(this)) {
                progressBar.visibility = View.VISIBLE //utilização de uma ProgressBar tornando-a visível

                val task = Database().incluir("users", id, usuario) //chamada do método incluir da classe Datase

                task.addOnCompleteListener { result ->
                    //quando a tarefa for concluída, executará o código a seguir

                    if (result.isSuccessful) {//se a tarefa for com sucesso não exibir a progressBar, mostrar mensagem e limpar os campos
                        progressBar.visibility = View.GONE
                        Util.showMessage(this,"Aluno cadastro com sucesso!")

                    } else {
                        progressBar.visibility =
                            View.GONE //se a tarefa não for concluída com sucesso, a progressBar também não será exibida e será mostrada uma mensagem para o usuário
                        Util.showMessage(this,"Houve erro no cadastro do Aluno")
                    }
                }
                //se não houver conexão com a internet, exibe mensagem.
            } else {
                Util.showMessage(this,"Sem conexão com a internet")
            }
        }
  //  }


}
