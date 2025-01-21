package com.pa.aerodream.utils;

import com.pa.aerodream.persistence.entity.enums.EnumRol;

public final class Constants {

    private Constants(){}

    public static class Message{
        public static final String START_SERVICE = "INICIO DE SERVICIO";
        public static final String REQUEST = "REQUEST -> \n";
        public static final String RESPONSE = "RESPONSE -> \n";
        public static final String FINISH_SERVICE = "FINALIZA SERVICIO";
        public static final String SUCCESS_OPERATION= "OPERACION EXITOSA";
        public static final String ERROR_OPERATION = "ERROR EN LA OPERACION";
        public static final String BAD_OPERATION = "OPERACION INVALIDA";

        public static final String JSON_ERROR = "ERROR EN LA CONVERSION A JSON";

        public static final String REGEX_NUMERIC = "SOLO SE ACEPTAN VALORES NUMERICOS";
        public static final String REGEX_ALPHANUMERIC = "SOLO SE ACEPTAN VALORES ALFANUMERICOS";
        public static final String REGEX_DATE = "FORMATO DE FECHA INVALIDO";
        public static final String REGEX_LETTERS = "SOLO SE ACEPTAN CARACTERES";
        public static final String REGEX_LETTERS_AND_SPACES = "SOLO SE ACEPTAN CARACTERES Y ESPACIOS";
        public static final String REGEX_ADDRESS = "FORMATO DE DIRECCION INVALIDO, VER DOCUMENTACION";

        private Message(){}
    }

    public static class Global{
        public static final String API_BASE_PATH = "/api";
        public static final String API_VERSION = "/v1";
        public static final String API_AUTH = "/auth";
        public static final String API_LOGIN = "/login";
        public static final String API_REGISTER = "/register";
        public static final String API_HOME = "/home";
        private Global(){}
    }

    public static class Vuelo{
        public static final String VUELO_SERVICE_PATH = "/vuelo";
        public static final String VUELO_SERVICE_SEARCH = "/buscar";
        public static final String VUELO_SERVICE_SAVE = "/guardar";
        public static final String VUELO_SERVICE_UPDATE = "/actualizar";
        public static final String VUELO_SERVICE_DELETE = "/eliminar";
        public static final String VUELO_SERVICE_ORIGIN = "/buscarPorOrigen";
        public static final String VUELO_SERVICE_DESTINE = "/buscarPorDestino";
        private Vuelo(){}
    }

    public static class Reserva{
        public static final String RESERVA_SERVICE_PATH = "/reserva";
        public static final String RESERVA_SERVICE_BOOKING = "/booking";
        public static final String RESERVA_SERVICE_BOOKED = "/booked";
        public static final String RESERVA_SERVICE_SAVE = "/guardar";
        public static final String RESERVA_SERVICE_UPDATE = "/actualizar";
        public static final String RESERVA_SERVICE_DELETE = "/eliminar";
        private Reserva(){}
    }

    public static class User{
        public static final String USER_ROLE_ADMIN = EnumRol.ADMIN.name();
        public static final String USER_ROLE_CLIENT = EnumRol.CLIENT.name();
        private User(){}
    }

    public static class Operation{
        public static final String OPERATION_REGISTER = "REGISTRO DE USUARIO";
        public static final String OPERATION_LOGIN = "AUTENTICACION DE USUARIO";
        private Operation(){}
    }

    public static class Formats{
        public static final String FORMAT_DATE_1 = "yyyyMMdd";
        public static final String FORMAT_DATE_2 = "yyyy-MM-dd:mm:ss.SSSSSS";
        public static final String FORMAT_DATE_3 = "yyyy-MM-dd";

        public static final String FORMAT_HOUR_1 = "HH:mm:ss";

        public static final String FORMAT_AMOUNT_1 = "'$'###,###,###";

        private Formats(){}
    }

}