pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat './gradlew build'
            }
        }
        stage('Test') {
            steps {
                bat './gradlew check'
            }
        }
    }
}