pipeline {
    agent any

    stages {
        stage('Compilar') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Probar') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Generar reportes') {
            steps {
                bat 'mvn allure:serve'
            }
        }
    }
}