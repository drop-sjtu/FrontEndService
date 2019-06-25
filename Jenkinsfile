pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'

                dir('backend') {
                    sh 'mvn clean'
                    sh 'mvn package -Dmaven.test.skip=true'

                    dir('login') {
                        sh 'mvn dockerfile:build'
                    }

                    dir('play') {
                        sh 'mvn dockerfile:build'
                    }

                    dir('eureka-server') {
                        sh 'mvn dockerfile:build'
                    }

                    dir('gateway') {
                        sh 'mvn dockerfile:build'
                    }
                }

                dir('frontend') {
                    sh 'npm install'
                    sh 'npm run build'
                    sh 'docker build . -t react-docker'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing..'

                dir('backend') {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying..'
                cleanWs()
            }
        }
    }
}
