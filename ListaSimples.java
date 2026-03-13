public class ListaSimples implements ListaOperacoes{
    String[] lista;


    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }


    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }


    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }




    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }


    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }


    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }


    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }


    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }


    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }


    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }


    @Override
    public int contar() {
        int cont = 0;
        for (String s : lista) {
            if (s != null) cont++;
        }
        return cont;
    }


    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                lista[i] = null;
                removidos++;
            }
        }
        return removidos;
    }


    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (String e : elementos) {
            if (!estaCheia()) {
                lista[encontrarPosicaoVazia()] = e;
                adicionados++;
            }
        }
        return adicionados;
    }


    @Override
    public String obter(int i) {
        if (i < 0 || i >= lista.length) return null;
        return lista[i];
    }


    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= lista.length || estaCheia()) return false;
        for (int i = lista.length - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }
        lista[indice] = elemento;
        return true;
    }


    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= lista.length || lista[indice] == null) return null;
        String removido = lista[indice];
        for (int i = indice; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[lista.length - 1] = null;
        return removido;
    }


    @Override
    public void limpar() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = null;
        }
    }


    @Override
    public int ultimoIndiceDe(String elemento) {
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] != null && lista[i].equals(elemento)) return i;
        }
        return -1;
    }


    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        for (String s : lista) {
            if (s != null && s.equals(elemento)) cont++;
        }
        return cont;
    }


    @Override
    public int substituir(String antigo, String novo) {
        int subs = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(antigo)) {
                lista[i] = novo;
                subs++;
            }
        }
        return subs;
    }
}
