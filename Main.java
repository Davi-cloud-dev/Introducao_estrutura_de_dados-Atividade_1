public class Main {
    public static void main(String[] args) {
        System.out.println("--- Demonstração Lista Simples ---");
        ListaSimples listaCompras = new ListaSimples(8); //cap. máxima de 8

        //testando adicionarElemento
        System.out.println("\n*** Adicionando itens à lista de compras ***");
        listaCompras.adicionarElemento("Arroz");
        listaCompras.adicionarElemento("Feijão");
        listaCompras.adicionarElemento("Macarrão");
        listaCompras.adicionarElemento("Arroz"); //duplicado
        listaCompras.adicionarElemento("Leite");
        listaCompras.adicionarElemento("Pão");

        //testando exibirElementos
        System.out.println("\n--- Lista de compras atual ---");
        listaCompras.exibirElementos();

        //testando contar()
        System.out.println("\n--- Quantidade de itens ---");
        System.out.println("Total de itens: " + listaCompras.contar());

        //testando buscarElemento
        System.out.println("\n--- Buscando itens ---");
        listaCompras.buscarElemento("Leite");
        listaCompras.buscarElemento("Café");

        //testando alterarElemento
        System.out.println("\n--- Alterando item ---");
        listaCompras.alterarElemento("Pão", "Requeijão");

        //testando obter()
        System.out.println("\n--- Obtendo item por índice ---");
        System.out.println("Item no índice 2: " + listaCompras.obter(2));
        System.out.println("Item no índice 10: " + listaCompras.obter(10)); //invalido

        //testando contarOcorrencias()
        System.out.println("\n--- Contando ocorrências ---");
        System.out.println("Vezes que o item 'Arroz' aparece: " + listaCompras.contarOcorrencias("Arroz"));

        //testando ultimoIndiceDe()
        System.out.println("\n--- Último índice de um elemento ---");
        System.out.println("Último índice de 'Arroz': " + listaCompras.ultimoIndiceDe("Arroz"));
        System.out.println("Último índice de 'Café': " + listaCompras.ultimoIndiceDe("Café"));

        //testando inserir()
        System.out.println("\n--- Inserindo item em um índice específica ---");
        listaCompras.inserir(2, "Café");
        listaCompras.exibirElementos();

        //testando adicionarVarios()
        System.out.println("\n--- Adicionando vários itens de uma vez ---");
        String[] novosItens = {"Açúcar", "Sal", "Óleo", "Farinha"};
        int adicionados = listaCompras.adicionarVarios(novosItens);
        System.out.println("Itens adicionados: " + adicionados);
        listaCompras.exibirElementos(); //exibe com os novos itens adicionados

        //testando removerElemento()
        System.out.println("\n--- Removendo um item ---");
        listaCompras.removerElemento("Macarrão");
        listaCompras.exibirElementos();

        //testando removerPorIndice()
        System.out.println("\n--- Removendo item por índice ---");
        String removido = listaCompras.removerPorIndice(3);
        System.out.println("Item removido: " + removido);
        listaCompras.exibirElementos();

        //testando removerTodas()
        System.out.println("\n--- Removendo todas as ocorrências de 'Arroz' ---");
        int totalRemovidos = listaCompras.removerTodas("Arroz");
        System.out.println("Total removidos: " + totalRemovidos);
        listaCompras.exibirElementos();

        //testando substituir()
        System.out.println("\n--- Substituindo 'Leite' por 'Doce de Leite' ---");
        int substituicoes = listaCompras.substituir("Leite", "Doce de Leite");
        System.out.println("Total substituições: " + substituicoes);
        listaCompras.exibirElementos();

        //testando quantidadeElementos()
        System.out.println("\n--- Quantidade de elementos ---");
        listaCompras.quantidadeElementos();

        //testando limpar()
        System.out.println("\n--- Limpando a lista ---");
        listaCompras.limpar();
        listaCompras.exibirElementos();
        System.out.println("Total após limpar: " + listaCompras.contar());


        System.out.println("\n\n");
        System.out.println("*** Demonstração Lista Dinâmica ***");
        ListaDinamica listaTarefas = new ListaDinamica();

        //testando adicionarElemento
        System.out.println("\n--- Adicionando tarefas ---");
        listaTarefas.adicionarElemento("Estudar Java");
        listaTarefas.adicionarElemento("Fazer exercícios");
        listaTarefas.adicionarElemento("Revisar matéria");
        listaTarefas.adicionarElemento("Estudar Java"); //duplicado

        //testando exibirElementos
        System.out.println("\n--- Lista de tarefas ---");
        listaTarefas.exibirElementos();

        //testando contar()
        System.out.println("\n--- Total de tarefas ---");
        System.out.println("Total: " + listaTarefas.contar());

        //testando buscarElemento
        System.out.println("\n--- Buscando tarefas ---");
        listaTarefas.buscarElemento("Fazer exercícios");
        listaTarefas.buscarElemento("Dormir");

        //testando contarOcorrencias()
        System.out.println("\n--- Contando ocorrências ---");
        System.out.println("Vezes que 'Estudar Java' aparece: " + listaTarefas.contarOcorrencias("Estudar Java"));

        //testando ultimoIndiceDe()
        System.out.println("\n--- Último índice de uma tarefa ---");
        System.out.println("Último índice de 'Estudar Java': " + listaTarefas.ultimoIndiceDe("Estudar Java"));

        //testando obter()
        System.out.println("\n--- Obtendo tarefa por índice ---");
        System.out.println("Tarefa no índice 1: " + listaTarefas.obter(1));
        System.out.println("Tarefa no índice 5 (inválido): " + listaTarefas.obter(5));

        //testando inserir()
        System.out.println("\n--- Inserindo tarefa em posição específica ---");
        listaTarefas.inserir(2, "Fazer pausa");
        listaTarefas.exibirElementos();

        //testando adicionarVarios()
        System.out.println("\n--- Adicionando várias tarefas ---");
        String[] novasTarefas = {"Ler livro", "Meditar", "Alongar"};
        int adicionadas = listaTarefas.adicionarVarios(novasTarefas);
        System.out.println("Tarefas adicionadas: " + adicionadas);
        listaTarefas.exibirElementos();

        //testando removerElemento()
        System.out.println("\n--- Removendo uma tarefa específica ---");
        listaTarefas.removerElemento("Revisar matéria");
        listaTarefas.exibirElementos();

        // Testando removerPorIndice()
        System.out.println("\n--- Removendo uma tarefa por índice ---");
        String tarefaRemovida = listaTarefas.removerPorIndice(1);
        System.out.println("Tarefa removida: " + tarefaRemovida);
        listaTarefas.exibirElementos();

        //testando removerTodas()
        System.out.println("\n--- Removendo todas as ocorrências de 'Estudar Java' ---");
        int removidosTotal = listaTarefas.removerTodas("Estudar Java");
        System.out.println("Total removido: " + removidosTotal);
        listaTarefas.exibirElementos();

        //testando substituir()
        System.out.println("\n--- Substituindo 'Fazer pausa' por 'Fazer pausa de 15min' ---");
        int subs = listaTarefas.substituir("Fazer pausa", "Fazer pausa de 15min");
        System.out.println("Total substituições: " + subs);
        listaTarefas.exibirElementos();

        //testando limpar()
        System.out.println("\n--- Limpando todas as tarefas ---");
        listaTarefas.limpar();
        listaTarefas.exibirElementos();
        System.out.println("Total após limpar: " + listaTarefas.contar());
    }
}
