# Jenkins CI (Shared Library)

[![Build](https://img.shields.io/badge/Build-%23d33833?style=for-the-badge&logo=jenkins&logoColor=white)](https://jenkins.billalsaidi.fr/)
[![codecov](https://codecov.io/gh/billal280/Jenkins-CI/branch/main/graph/badge.svg)](https://codecov.io/gh/billal280/Jenkins-CI)

## 📌 Introduction
Cette Shared Library Jenkins permet de centraliser et de réutiliser des scripts Groovy pour les pipelines Jenkins. Elle facilite la gestion des builds, tests et déploiements.

## 📂 Structure du Projet
```code
jenkins-CI/
├── vars/                  # Pipelines utilisables dans les Jenkinsfile
│   └── pipeline.groovy    # PaC pipeline exemple
├── resources/             # Fichiers de configuration (si nécessaires)
├── src/                   # Class (contenant les méthodes/fonctions utilisables dans nos PaC)
└── README.md              # Documentation du projet
```

## ⚙️ Utilisation dans un `Jenkinsfile`
```groovy
library identifier: 'JenkinsCI@v1',
retriever: modernSCM([ $class: 'GitSCMSource',
credentialsId: 'GITHUB_ID',
remote: 'https://github.com/billal280/Jenkins-CI.git' ]) 


pipeline()

