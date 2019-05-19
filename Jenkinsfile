pipeline {
    agent any
    
    tools {
        maven 'Maven 3.6.1'
        jdk 'jdk11'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                mvn clean
                mvn package -Dmaven.test.skip=true
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                mvn test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}
