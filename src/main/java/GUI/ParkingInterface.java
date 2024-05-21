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

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.util.regex.Pattern;
import java.util.regex.Matcher;





@SuppressWarnings("serial")
public class ParkingInterface extends JFrame
{

    private final String regex = "^[a-z]{3}[0-9]{3}$";
    public Pattern pattern;
    //private Parking parking;

    // -----------------------------------------------------------------
    // Componentes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel que muestra el banner de la aplicaci�n.
     */
    private ImagePanel imagePanel;

    /**
     * Es el panel que muestra el parqueadero.
     */
    private ParkingPanel parkingPanel;

    /**
     * Es el panel donde se realizan las operaciones.
     */
    private OptionsPanel optionsPanel;

    /**
     * Es el panel que muestra informaci�n sobre el parqueadero.
     */
    private InfoPanel infoPanel;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Sirve para construir la interfaz.
     */
    public ParkingInterface( )
    {
        this.pattern = Pattern.compile(regex);
        setTitle( "Parking" );
        setSize( 570, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea el parqueadero con tarifa por hora de 1200

       // parqueadero = new Parqueadero( );

        // Construir los paneles
        imagePanel = new ImagePanel( );
        //parkingPanel = new ParkingPanel( parqueadero );
        optionsPanel = new OptionsPanel( this );
        optionsPanel.setPreferredSize( new Dimension( 570, 100 ) );
        infoPanel = new InfoPanel( this );
        JPanel sur = new JPanel( );
        sur.setLayout( new BorderLayout( ) );

        // Organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        getContentPane( ).add(imagePanel, BorderLayout.NORTH );
        getContentPane( ).add(parkingPanel, BorderLayout.CENTER );
        getContentPane( ).add( sur, BorderLayout.SOUTH );
        sur.add(optionsPanel, BorderLayout.CENTER );
        sur.add(infoPanel, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Sirve para hacer plusOneHour una hora el reloj del parqueadero.
     */

    public void plusOneHour( )
    {
        parqueadero.avanzarHora( );
        actualizar( );
    }

    /**
     * Este m�todo sirve para ingresar un carro al parqueadero. Debe preguntar la placa del carro e informar la posici�n donde debe estacionarse. <br>
     * Si no se puede parquear, porque el parqueadero est� cerrado o porque no hay ning�n lugar disponible, entonces debe informar del error.
     */

    public void ingresar( )
    {
        String carPlate = JOptionPane.showInputDialog( this, "Por favor digite la carPlate del carro que est� ingresando", "Ingresar carro", JOptionPane.QUESTION_MESSAGE );
        Matcher matcher = this.pattern.matcher(carPlate);
        if( carPlate != null &&  matcher.matches())
        {
            int puesto = parking.entrarCarro( carPlate );
            switch( puesto )
            {
                case Parking.NO_HAY_PUESTO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está lleno" );
                    break;
                case Parking.CARRO_YA_EXISTE:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: ya hay un carro parqueado con la misma carPlate" );
                    break;
                case Parking.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está cerrado" );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro quedá parqueado en el puesto: " + ( puesto + 1 ) );
                    break;
            }
            actualizar( );
        }

    }

    /**
     * Este m�todo permite cambiar la tarifa del parqueadero. Pide una tarifa al usuario, si esta tarifa no es v�lida informa al usuario.
     */

    public void cambiar( )
    {
        String tarifa = JOptionPane.showInputDialog( this, "Por favor digi  te la nueva tarifa", "Nueva tarifa", JOptionPane.QUESTION_MESSAGE );
        if( tarifa != null )
        {
            try
            {
                int tarifaNumero = Integer.parseInt( tarifa );
                if( tarifaNumero <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una tarifa v�lida", "Tarifa inv�lida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    parqueadero.cambiarTarifa( tarifaNumero );
                    optionsPanel.cambiarTarifa( tarifaNumero );
                    JOptionPane.showMessageDialog( this, "Se ha cambiado la tarifa", "Nueva tarifa", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una tarifa v�lida", "Tarifa inv�lida", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Este m�todo sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber <br>
     * cu�nto debe cancelar. Si la placa no corresponde a un carro que est� en el parqueadero entonces debe mostrar un error.
     */

    public void salir( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que est� saliendo", "Salida carro", JOptionPane.QUESTION_MESSAGE );
        if( placa != null )
        {
            int valor = parqueadero.sacarCarro( placa );
            switch( valor )
            {
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero est� cerrado", "Error", JOptionPane.ERROR_MESSAGE );
                    break;
                case Parqueadero.CARRO_NO_EXISTE:
                    JOptionPane.showMessageDialog( this, "El carro de placa " + placa + " no est� en el parqueadero", "Error", JOptionPane.ERROR_MESSAGE );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Placa: " + placa + " debe cancelar $ " + valor );
                    break;
            }
            actualizar( );
        }
    }

    /**
     * Este m�todo se encarga de actualizar los datos que se presentan en la interfaz.
     */

    public void actualizar( )
    {
        parkingPanel.refrescarParqueadero( );
        optionsPanel.cambiarHora( parqueadero.darHoraActual( ) );
        optionsPanel.cambiarTarifa( parqueadero.darTarifa( ) );
        infoPanel.actualizarDatos( parqueadero.calcularPuestosLibres( ), parqueadero.darMontoCaja( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la opci�n 1.
     */

    public void reqFuncOpcion1( )
    {
        parqueadero.desocupaParqueadero();
        actualizar( );
        JOptionPane.showMessageDialog( this, "Carros desocupados, cupos libres: "+parqueadero.calcularPuestosLibres());
    }

    /**
     * Este m�todo ejecuta la opci�n 2.
     */

    public void reqFuncOpcion2( )
    {
        String respuesta = parqueadero.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            ParkingInterface manejador = new ParkingInterface( );
            manejador.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}