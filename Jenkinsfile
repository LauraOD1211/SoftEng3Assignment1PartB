pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat './gradlew build'
            }
        }
        stage('test') {
            steps {
                bat './gradlew check'
            }
        }
        stage('deploy') {
            steps {
                bat './gradlew war'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true
        }
    }
}