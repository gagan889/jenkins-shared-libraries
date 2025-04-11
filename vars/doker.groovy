def call(){
  echo "Start pushing the image to Docker-Hub"
  withCredentials([usernamePassword(credentialsId: 'jenkins-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
  sh """
    docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
    docker image tag notes-app:latest ${DOCKER_USER}/notes-app:latest
    docker push ${DOCKER_USER}/notes-app:latest
                    """ 
  }
