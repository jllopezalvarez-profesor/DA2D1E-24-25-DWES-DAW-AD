package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

/**
 * Enum que representa los tipos de tokens JWT utilizados en la aplicación.
 * <p>
 * Este enum define los dos tipos de tokens que se pueden generar y utilizar:
 * - ACCESS: Token de acceso, que se utiliza para autenticar las solicitudes de los usuarios.
 * - REFRESH: Token de refresco, que se utiliza para obtener un nuevo token de acceso cuando el original ha caducado.
 * </p>
 */
public enum JwtTokenType {
    ACCESS, REFRESH
}
