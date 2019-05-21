package com.prjproduto.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.prjproduto.dominio.Produto;
import com.prjproduto.persistencia.CRUDProduto;

public class GerenciarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtFabricante;
	private JTextField txtPreco;
	private JLabel lblDescricao;
	private JLabel lblFabricante;
	private JLabel lblQuantidade;
	private JLabel lblPreco;
	private JTable tbCadastrar;
	private Produto produto;
	private CRUDProduto crud;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarProdutos frame = new GerenciarProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.

	 */
	public GerenciarProdutos() {
		
		produto = new Produto();
		crud = new CRUDProduto();
		
		
		
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(30, 44, 549, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(30, 105, 549, 43);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(115, 243, 96, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(30, 186, 549, 20);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);
		
		JLabel lblNomedoProduto = new JLabel("Nome do Produto:");
		lblNomedoProduto.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNomedoProduto.setBounds(30, 21, 166, 14);
		contentPane.add(lblNomedoProduto);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(297, 243, 96, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDescricao.setBounds(30, 80, 147, 14);
		contentPane.add(lblDescricao);
		
		lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFabricante.setBounds(30, 159, 173, 20);
		contentPane.add(lblFabricante);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblQuantidade.setBounds(30, 244, 84, 14);
		contentPane.add(lblQuantidade);
		
		lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPreco.setBounds(254, 244, 48, 14);
		contentPane.add(lblPreco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				produto.setNome(txtNome.getText());
				produto.setDescricao(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				String retorno = crud.cadastrar(produto);
				
				JOptionPane.showMessageDialog(null, retorno);
				
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				
				
				
				
			}

			
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setBounds(30, 287, 106, 23);
		contentPane.add(btnCadastrar);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				String id = JOptionPane.showInputDialog("Digite o Id do Produto");
				// passar os dados do formulário para o objeto cliente
				produto.setNome(txtNome.getText());
				produto.setDescricao(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				produto.setId(Integer.parseInt(id));

				String retorno = crud.atualizar(produto);

				JOptionPane.showMessageDialog(null, retorno);
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				id = "0";

			}
		});
				
				
		
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBounds(165, 287, 89, 23);
		contentPane.add(btnAtualizar);
		
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do produto para apagar");
				
				JOptionPane.showMessageDialog(null, crud.deletar(produto));	
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletar.setBounds(283, 287, 89, 23);
		contentPane.add(btnDeletar);
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(401, 287, 106, 23);
		contentPane.add(btnPesquisar);
carregardados();
		
		
	}
	
	private void carregardados() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 345, 549, 210);
		contentPane.add(scrollPane);
		
String[] colunas = {"Id","Nome","Descrição","Fabricante","Quantidade","Preço"};
		
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		for(Produto c : crud.PesquisarTodos()) {
			modelo.addRow(new Object[] {
			c.getId(),
			c.getNome(),
			c.getDescricao(),
			c.getFabricante(),
			c.getQuantidade(),
			c.getPreco()
			});
		}
		
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
	}
}