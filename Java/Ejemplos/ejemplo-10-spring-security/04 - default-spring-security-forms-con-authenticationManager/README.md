# ¿Qué tiene este ejemplo?

Este ejemplo deriva de la versión "03 - default-spring-security-forms-con-userDetailsService".

Esta versión es esencialmente igual que la 03, pero, además de proporcionar @Bean / @Component para UserDetailService y
PasswordEncoder, se proporcionan para el AuthenticationManager y un AuthenticationProvider.

Los nuevos @Bean son, básicamente, iguales que los que crea por defecto Spring si no los creamos explícitamente.

La idea de poder crearlos de forma explícita es tener más control sobre lo que se está haciendo. Entre otras cosas, esto
permite crear varios AuthenticationProvider, para poder autenticar al usuario con distintos mecanismos. Google,
Facebook, usuarios de aplicación, etc.

El manager y provider se crean en el mismo método. En este método podrían crearse y añadirse otros providers.

