pipeline {
    agent any

    stages {
        stage('Compilar') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Probar') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generar reportes') {
            steps {
                sh 'mvn allure:serve'
            }
        }
    }
}