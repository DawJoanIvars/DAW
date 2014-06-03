import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class FichaPolicia extends JFrame {

	//Elementos de la pantalla
	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Edad;
	private JTextField Altura;
	private JTextField Crimen;
	private Delincuente delincuente;
	private BaseDatos datos;
	
	//ComboBox para guardar delincuentes
	private JComboBox<Delincuente> delincuentes;
	private JTextField textID;

	//Lanza la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaPolicia frame = new FichaPolicia();
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
	public FichaPolicia() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		delincuentes = new JComboBox<Delincuente>();
		delincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cojemos del comboBox la informacion y la pone en su sitio
				delincuente=delincuentes.getItemAt(delincuentes.getSelectedIndex());
				if(delincuente!=null)
				{
				Nombre.setText(delincuente.getNombre());
				Edad.setText(String.valueOf(delincuente.getEdad()));
				Crimen.setText(delincuente.getCrimen());
				Altura.setText(String.valueOf(delincuente.getAltura()));
				textID.setText(String.valueOf(delincuente.getId()));
				}
			}
		});
		delincuentes.setBounds(10, 49, 414, 20);
		contentPane.add(delincuentes);
		
		JLabel lblNombreDelicuente = new JLabel("Ficha");
		lblNombreDelicuente.setBounds(10, 25, 308, 14);
		contentPane.add(lblNombreDelicuente);
		
		JLabel lblApellidosNombre = new JLabel("Apellidos, Nombre");
		lblApellidosNombre.setBounds(10, 80, 158, 14);
		contentPane.add(lblApellidosNombre);
		
		Nombre = new JTextField();
		Nombre.setBounds(10, 105, 414, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 136, 88, 14);
		contentPane.add(lblEdad);
		
		Edad = new JTextField();
		Edad.setColumns(10);
		Edad.setBounds(10, 161, 88, 20);
		contentPane.add(Edad);
		
		JLabel lblAltura = new JLabel("Altura (cm)");
		lblAltura.setBounds(10, 197, 88, 14);
		contentPane.add(lblAltura);
		
		Altura = new JTextField();
		Altura.setColumns(10);
		Altura.setBounds(10, 222, 88, 20);
		contentPane.add(Altura);
		
		JLabel lblCrimen = new JLabel("Crimen");
		lblCrimen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrimen.setBounds(336, 136, 88, 14);
		contentPane.add(lblCrimen);
		
		//Boton Guardar
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Aquí realizaremos los siguientes pasos
				//1.- Comprobaremos que todos los campos están completados
				if((Nombre.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "Has introducido mal el Nombre");
				}
				else if((Edad.getText().equals(""))){
					JOptionPane.showMessageDialog(null, "Has introducido mal la Edad");
				}
				else if((Crimen.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "Has introducido mal el Crimen");
				}
				else if((Altura.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "Has introducido mal la Altura");
				} 
				else{
				//2.- Crearemos un nuevo objeto delincuente
				Delincuente del=new Delincuente();
				int ID=0;
				ID=datos.insertarDelincuentes(Nombre.getText(), Integer.parseInt(Edad.getText()), Crimen.getText(), Integer.parseInt(Altura.getText()));
				del.setNombre(Nombre.getText());
				del.setEdad(Integer.parseInt(Edad.getText()));
				del.setCrimen(Crimen.getText());
				del.setAltura(Integer.parseInt(Altura.getText()));
				del.setId(ID);
				
				
				//3.- Lo almacenaremos en el ComboBox
				delincuentes.addItem(del);
				}
			}
		});
		botonGuardar.setBounds(10, 272, 89, 23);
		contentPane.add(botonGuardar);
		
		Crimen = new JTextField();
		Crimen.setBounds(148, 161, 276, 20);
		contentPane.add(Crimen);
		Crimen.setColumns(10);
		//Boton Modificar
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datos.modificaDelincuentes(Integer.parseInt(textID.getText()),Nombre.getText(), Integer.parseInt(Edad.getText()), Crimen.getText(), Integer.parseInt(Altura.getText()));
				delincuente.setNombre(Nombre.getText());
				delincuente.setEdad(Integer.parseInt(Edad.getText()));
				delincuente.setCrimen(Crimen.getText());
				delincuente.setAltura(Integer.parseInt(Altura.getText()));
				
			}
		});
		botonModificar.setBounds(136, 272, 89, 23);
		contentPane.add(botonModificar);
		
		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Eliminamos el item seleccionado
				delincuentes.removeItem(delincuente);
				datos.remove(Integer.parseInt(textID.getText()));
			}
		});
		botonBorrar.setBounds(259, 272, 89, 23);
		contentPane.add(botonBorrar);

		datos=new BaseDatos(delincuentes);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(197, 197, 46, 14);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(177, 222, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		datos.leerDelincuentes();
	}
}
