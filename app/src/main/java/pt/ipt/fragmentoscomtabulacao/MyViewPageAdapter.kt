package pt.ipt.fragmentoscomtabulacao

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
 * Gestor dos Fragmentos
 */
class MyViewPageAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {

    /*
     * Devolve o numero de fragmentos a ser mostrado
     */
    override fun getItemCount(): Int {
        return 3
    }

        /* devolve o Fragmento pedido pelo parâmetro de entrada
         * @param número do fragmento a estanciar
         */
    override fun createFragment(posicao: Int): Fragment {
        return when(posicao){
            0->FragmentoEsquerda()
            1->FragmentoCentro()
            2->FragmentoDireita()
            else->FragmentoEsquerda()
        }


            /* outra hipótese
             *  when (posicao) {
             *      1-> return FragmentoEsquerda()
             *      2-> return FragmentoCentro()
             *      3-> return FragmentoDireita()
             *      else-> return FragmentoEsquerda()
             */
    }
}