public class ListaDinamica implements ListaOperacoes{
    No inicio;


    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }


    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }


    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }


    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }


    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }


                //removendo intermediário
                //método de busca
            }


        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }


    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;


        if(existeInicio()) {
            do {
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado.");
                    return true;
                }
                aux = aux.getProx();
            } while(aux != null);
        }


        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }


    @Override
    public int removerTodas(String elemento) {
        if(!existeInicio()) { //nenhum elemento
            return 0;
        }


        int removidos = 0;


        //remoções do início
        while(existeInicio() && this.inicio.getConteudo().equals(elemento)) {
            if(this.inicio.getProx() == null) { //caso tenha apenas 1 unico elemento
                this.inicio.setConteudo(null);
                removidos++;
                return removidos;
            } else { //mais de 1 elementos
                this.inicio = this.inicio.getProx(); //remover do início
                removidos++;
            }
        }


        if(!existeInicio()) { //se depois de remover do inicio a lista ficou vazia
            return removidos;
        }


        //remover do meio/fim
        No anterior = this.inicio;
        No atual = this.inicio.getProx();


        while(atual != null) {
            if(atual.getConteudo().equals(elemento)) {
                anterior.setProx(atual.getProx());
                removidos++;
                atual = anterior.getProx(); // reavaliar nova posição
            } else {
                anterior = atual;
                atual = atual.getProx();
            }
        }


        return removidos;
    }


    @Override
    public int contar() {
        if(!existeInicio()) {
            return 0;
        }


        int conta = 0;
        No aux = this.inicio;
        while(aux != null) {
            conta++;
            aux = aux.getProx();
        }
        return conta;
    }


    @Override
    public int adicionarVarios(String[] elementos) {
        if(elementos == null) {
            System.out.println("Não se pode adicionar uma string vazia");
            return 0;
        }


        int adicionados = 0;
        for(String elemento : elementos) {
            adicionarElemento(elemento);
            adicionados++;
        }
        return adicionados;
    }


    @Override
    public String obter(int indice) {
        if(indice < 0 || !existeInicio()) {
            return null;
        }


        if(indice >= contar()){
            return null;
        }


        No aux = this.inicio;
        int posicao = 0;


        while(aux != null) {
            if(posicao == indice) {
                return aux.getConteudo();
            }
            aux = aux.getProx();
            posicao++;
        }


        return null;
    }


    @Override
    public boolean inserir(int indice, String elemento) {
        if(indice < 0) {
            return false;
        }


        if(indice == 0) { //caso queira inserir no início
            if(!existeInicio()) {
                this.inicio.setConteudo(elemento);
                return true;
            } else {
                No novoNo = new No(elemento);
                novoNo.setProx(this.inicio); //ele consideraria que o indice é 1 ao invés de dar erro
                this.inicio = novoNo;
                return true;
            }
        }


        if(indice >= contar()) {
            return false;
        }




        No anterior = this.inicio;
        int posicao = 0;


        while(anterior != null && posicao < indice - 1) {
            anterior = anterior.getProx();
            posicao++;
        }


        if(anterior == null) {
            return false; //índice invalido
        }


        No novoNo = new No(elemento);
        novoNo.setProx(anterior.getProx());
        anterior.setProx(novoNo);
        return true;
    }


    @Override
    public String removerPorIndice(int indice) {
        if(indice < 0 || !existeInicio()) {
            return null;
        }


        if(indice == 0) { //caso seja o primeiro elemento
            String removido = this.inicio.getConteudo();


            if(this.inicio.getProx() == null) { //elemento único
                this.inicio.setConteudo(null);
            } else {
                this.inicio = this.inicio.getProx();
            }
            return removido;
        }


        No anterior = this.inicio;
        int pos = 0;


        while(anterior != null && pos < indice - 1) {
            anterior = anterior.getProx();
            pos++;
        }


        if(anterior == null || anterior.getProx() == null) {
            return null; //indice invalido
        }


        No removido = anterior.getProx();
        String valorRemovido = removido.getConteudo();
        anterior.setProx(removido.getProx());


        return valorRemovido;
    }


    @Override
    public void limpar() {
        this.inicio = new No(null);
        System.out.println("Lista Dinamica limpada com sucesso.");
    }


    @Override
    public int ultimoIndiceDe(String elemento) {
        if(!existeInicio()) {
            return -1; //retorna -1 se não encontrar
        }


        int ultimoIndice = -1;
        int pos = 0;
        No aux = this.inicio;


        while(aux != null) {
            if(aux.getConteudo().equals(elemento)) {
                ultimoIndice = pos;
            } //mesmo que ele ache o indice do elemento, se tiver o mesmo elemento depois ele não vai parar até a lista acabar
            aux = aux.getProx();
            pos++;
        }


        return ultimoIndice;
    }


    @Override
    public int contarOcorrencias(String elemento) {
        if(!existeInicio()) {
            return 0;
        }


        int ocorrencias = 0;
        No aux = this.inicio;


        while(aux != null) {
            if(aux.getConteudo().equals(elemento)) {
                ocorrencias++;
            }
            aux = aux.getProx();
        }


        return ocorrencias;
    }


    @Override
    public int substituir(String antigo, String novo) {
        if(!existeInicio()) {
            return 0;
        }


        int substituicoes = 0;
        No aux = this.inicio;


        while(aux != null) {
            if(aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                substituicoes++;
            }
            aux = aux.getProx();
        }


        return substituicoes;
    }
}
