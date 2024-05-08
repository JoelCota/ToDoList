/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Dominio.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.itson.excepciones.BOException;
import org.itson.implementaciones.FachadaBO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // Size threshold for storing files in memory
    maxFileSize = 5 * 1024 * 1024, // Maximum file size allowed
    maxRequestSize = 20 * 1024 * 1024 // Maximum request size allowed
)
@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

    FachadaBO fachadaBO = new FachadaBO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("registrar")) {
            this.cargarRegistro(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("logout")) {
            this.proccessLogout(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("login")) {
            this.cargarLogin(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("irPerfil")) {
            this.cargarPerfil(request, response);
//            this.cargarVerPublicacionesPerfil(request, response);
            return;
        }
    }
   
    /**
     * Carga y actualiza el perfil de un usuario en la aplicación web.
     *
     * @param request Objeto HttpServletRequest que representa la solicitud
     * HTTP.
     * @param response Objeto HttpServletResponse que representa la respuesta
     * HTTP.
     * @throws ServletException Si ocurre algún error durante la ejecución del
     * servlet.
     * @throws IOException Si ocurre algún error de entrada o salida.
     */
    private void cargarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();       
        Usuario usuario = (Usuario)sesion.getAttribute("usuario");
        sesion.removeAttribute("usuario");
        usuario = fachadaBO.consultarUsuarioPorId(usuario.getId());
        sesion.setAttribute("usuario", usuario);
        String pagina = "/paginas/perfil.jsp";
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    /**
     * Carga la página de inicio de sesión (login.jsp) en la aplicación web.
     *
     * @param request Objeto HttpServletRequest que representa la solicitud
     * HTTP.
     * @param response Objeto HttpServletResponse que representa la respuesta
     * HTTP.
     * @throws ServletException Si ocurre algún error durante la ejecución del
     * servlet.
     * @throws IOException Si ocurre algún error de entrada o salida.
     */
    private void cargarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/paginas/login.jsp";
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    /**
     * Carga la página de registro (registro.jsp) en la aplicación web y
     * consulta la lista de municipios.
     *
     * @param request Objeto HttpServletRequest que representa la solicitud
     * HTTP.
     * @param response Objeto HttpServletResponse que representa la respuesta
     * HTTP.
     * @throws ServletException Si ocurre algún error durante la ejecución del
     * servlet.
     * @throws IOException Si ocurre algún error de entrada o salida.
     */
    private void cargarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/paginas/registro.jsp";
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("iniciar-sesion")) {
            this.proccessLogin(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("registrar")) {
            try {
                this.processRegistration(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
    }

    /**
     * Procesa el inicio de sesión del usuario.
     *
     * @param request Objeto HttpServletRequest que representa la solicitud
     * HTTP.
     * @param response Objeto HttpServletResponse que representa la respuesta
     * HTTP.
     * @throws ServletException Si ocurre algún error durante la ejecución del
     * servlet.
     * @throws IOException Si ocurre algún error de entrada o salida.
     */
    private void proccessLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        // EXTRAER DATOS
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // VALIDAR DATOS
        if (email == null || email.isBlank() || email.trim().length() > 255
                || password == null || password.isBlank() || password.trim().length() > 255) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        // PROCESAR NEGOCIO
        try {
            Usuario usuario = fachadaBO.consultarCrendenciales(email, password);
            if (usuario == null) {
                getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
                return;
            }

          
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/taks?action=ver-tareas");
        } catch (BOException e) {
            // Manejar la excepción adecuadamente
            getServletContext()
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }
    }

    /**
     * Maneja el proceso de cierre de sesión de un usuario en la aplicación web.
     *
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @param response el objeto HttpServletResponse que representa la respuesta
     * a enviar al usuario.
     * @throws ServletException si ocurre algún error durante el procesamiento
     * del servlet.
     * @throws IOException si ocurre algún error de E/S durante el procesamiento
     * del servlet.
     */
    private void proccessLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("usuario");
        session.invalidate();

        getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
    }

    /**
     * Procesa el registro de un nuevo usuario en la aplicación web.
     *
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @param response el objeto HttpServletResponse que representa la respuesta
     * a enviar al usuario.
     * @throws ServletException si ocurre algún error durante el procesamiento
     * del servlet.
     * @throws IOException si ocurre algún error de E/S durante el procesamiento
     * del servlet.
     * @throws ParseException si ocurre algún error al analizar la fecha de
     * nacimiento del usuario.
     */
    private void processRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmar-contrasena");
        Map<String, String[]> parametros = request.getParameterMap();
        for (String key : parametros.keySet()) {
            String[] strArr = (String[]) parametros.get(key);
            for (String val : strArr) {
                request.setAttribute(key, val);
            }
        }
        if (validarNombre(nombre, request) && validarApellido(apellido, request)  && validarCorreo(correo, request)
                && validarContrasena(contrasena, confirmarContrasena, request)) {
           
        
            Usuario user = new Usuario(nombre, apellido, correo, contrasena);
            fachadaBO.registrarUsuario(user);
        } else {
            getServletContext().getRequestDispatcher("/paginas/registro.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
    }


    /**
     * Valida el campo de nombre en el formulario de registro.
     *
     * @param nombre el nombre a validar.
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @return true si el nombre es válido, false de lo contrario.
     */
    private boolean validarNombre(String nombre, HttpServletRequest request) {
        if (nombre == null) {
            request.setAttribute("error", "Ingrese un nombre");
            return false;
        }
        if (nombre.length() > 50) {
            request.setAttribute("error", "El nombre es demasiado largo");
            return false;
        }
        return true;
    }

    /**
     * Valida el campo de apellido en el formulario de registro.
     *
     * @param apellido el apellido a validar.
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @return true si el apellido es válido, false de lo contrario.
     */
    private boolean validarApellido(String apellido, HttpServletRequest request) {
        if (apellido == null) {
            request.setAttribute("error", "Ingrese un apellido");
            return false;
        }
        if (apellido.length() > 50) {
            request.setAttribute("error", "El apellido es demasiado largo");
            return false;
        }
        return true;
    }


    /**
     * Valida el campo de correo en el formulario de registro.
     *
     * @param correo el correo a validar.
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @return true si el correo es válido, false de lo contrario.
     */
    private boolean validarCorreo(String correo, HttpServletRequest request) {
        if (correo.isBlank()) {
            request.setAttribute("error", "Ingrese un correo");
            return false;
        }
        if (correo.length() > 50) {
            request.setAttribute("error", "El correo no es válido");
            return false;
        }
        return true;
    }

    /**
     * Valida los campos de contraseña y confirmación de contraseña en el
     * formulario de registro.
     *
     * @param contrasena la contraseña a validar.
     * @param confirmarContrasena la confirmación de contraseña a validar.
     * @param request el objeto HttpServletRequest que representa la solicitud
     * del usuario.
     * @return true si las contraseñas son válidas, false de lo contrario.
     */
    private boolean validarContrasena(String contrasena, String confirmarContrasena, HttpServletRequest request) {
        if (!contrasena.equals(confirmarContrasena)) {
            request.setAttribute("error", "Las contraseñas no coinciden");
            return false;
        }
        if (contrasena.isBlank() || confirmarContrasena.isBlank()) {
            request.setAttribute("error", "Ingrese una contraseña válida");
            return false;
        }
        if (contrasena.length() < 8) {
            request.setAttribute("error", "Contraseña muy corta");
            return false;
        }
        return true;
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
