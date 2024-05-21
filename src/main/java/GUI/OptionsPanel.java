/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueadero
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Este panel sirve para mostrar la hora actual y realizar las diferentes operaciones sobre el parqueadero.
 */
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando ingresar.
     */
    private final static String INGRESAR = "INGRESAR";

    /**
     * Comando salir.
     */
    private final static String SALIR = "SALIR";

    /**
     * Comando plusOneHour.
     */
    private final static String AVANZAR = "AVANZAR";

    /**
     * Comando cambiar.
     */
    private final static String CAMBIAR = "CAMBIAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la ventana principal de la aplicaci�n.
     */
    private ParkingInterface principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo de texto usado para mostrar la hora.
     */
    private JTextField txtHora;

    /**
     * Es el campo de texto usado para mostrar la tarifa.
     */
    private JTextField txtTarifa;

    /**
     * Es el bot�n para ingresar un carro al parqueadero.
     */
    private JButton botonEntrar;

    /**
     * Es el bot�n para sacar un carro del parqueadero.
     */
    private JButton botonSalir;

    /**
     * Es el bot�n para hacer plusOneHour una hora el reloj del parqueadero.
     */
    private JButton botonAvanzarHora;

    /**
     * Es el bot�n para cambiar la tarifa.
     */
    private JButton botonCambiar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b> Se construy� el panel.
     * @param pPrincipal Es una referencia a la ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public OptionsPanel(ParkingInterface pPrincipal )
    {
        principal = pPrincipal;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializar y organizar los componentes del panel.
     */
    private void inicializar( )
    {
        setLayout( new GridLayout( 3, 2, 3, 3 ) );
        setBorder( new EmptyBorder( 5,5,5,5 ) );

        JPanel panelHora = new JPanel();
        panelHora.setLayout( new GridLayout( 1,2) );
        add(panelHora);
        panelHora.add(new JLabel("Hora actual: "));
        
        txtHora = new JTextField( );
        txtHora.setEditable( false );
        txtHora.setForeground( Color.BLUE );
        //txtHora.setBackground( getBackground( ) );
        //txtHora.setBorder( new TitledBorder( "Hora Actual" ) );
        panelHora.add( txtHora );

        botonAvanzarHora = new JButton( );
        botonAvanzarHora.setText( "Avanzar" );
        botonAvanzarHora.setActionCommand( AVANZAR );
        botonAvanzarHora.addActionListener( this );
        add( botonAvanzarHora );

        JPanel panelTarifa = new JPanel();
        panelTarifa.setLayout( new GridLayout( 1,2) );
        add(panelTarifa);
        
        panelTarifa.add(new JLabel("Tarifa: "));
        txtTarifa = new JTextField( );
        txtTarifa.setEditable( false );
        txtTarifa.setForeground( Color.BLUE );
        //txtTarifa.setBackground( getBackground( ) );
        //txtTarifa.setBorder( new TitledBorder( "Tarifa" ) );
        panelTarifa.add( txtTarifa );

        botonCambiar = new JButton( );
        botonCambiar.setText( "Cambiar" );
        botonCambiar.setActionCommand( CAMBIAR );
        botonCambiar.addActionListener( this );
        add( botonCambiar );

        botonEntrar = new JButton( );
        botonEntrar.setText( "Ingresar Carro" );
        botonEntrar.setActionCommand( INGRESAR );
        botonEntrar.addActionListener( this );
        add( botonEntrar );

        botonSalir = new JButton( );
        botonSalir.setText( "Sacar Carro" );
        botonSalir.setActionCommand( SALIR );
        botonSalir.addActionListener( this );
        add( botonSalir );
    }

    /**
     * Cambia la hora presentada. <br>
     * <b>post: </b> Se est� mostrando la nueva hora.
     * @param pHora Nueva hora que debe mostrarse.
     */
    public void cambiarHora( int pHora )
    {
        txtHora.setText( pHora + ":00" );
    }

    /**
     * Cambia la tarifa presentada. <br>
     * <b>post: </b> Se est� mostrando la nueva tarifa.
     * @param pTarifa Nueva tarifa que debe mostrarse.
     */
    public void cambiarTarifa( int pTarifa )
    {
        txtTarifa.setText( "$" + pTarifa );
    }

    /**
     * Este m�todo ejecuta las acciones adecuadas seg�n el bot�n que haya sido presionado.
     * @param pEvento Es el evento del click sobre el bot�n.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( INGRESAR ) )
        {
            principal.ingresar( );
        }
        else if( command.equals( SALIR ) )
        {
            principal.salir( );
        }
        else if( command.equals( AVANZAR ) )
        {
            principal.plusOneHour( );
        }
        else if( command.equals( CAMBIAR ) )
        {
            principal.cambiar( );
        }
    }
}
