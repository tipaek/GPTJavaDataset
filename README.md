# GPTJavaDataset
<a name="readme-top"></a>

<br />
<div align="center">
  <a href="https://github.com/tipaek/GPTJavaDataset">
    <img src="https://cdn.iconscout.com/icon/free/png-256/free-java-file-51-775447.png" alt="logo of Java file" width="80" height="80">
  </a>

  <h3 align="center">GPT Java Source Code Dataset</h3>

  <p align="center">
    A dataset composed of 977 total Java source code files from 11 authors' GitHub pages and ChatGPT 3.5 and BingGPT rewritten code for code classification.
    <br />
    <a href="https://github.com/tipaek/GPTJavaDataset"><strong>Explore the files »</strong></a>
    <br />
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#composition">File Composiiton</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

With the release of OpenAI's ChatGPT, code written by GPT is becoming increasingly more common in everyday usage. However, students often use generated code to cheat on exams and homework. Being able to detect code written by GPT could be useful for organizations and schools as a classification or anomaly detection task. I wasn't able to find a publicly available online dataset of Java source code written by GPT to be trained on for research purposes, so I created my own. 

Here's the general idea:
* 666 Java source code files from 11 different authors' GitHub pages were acquired via another public dataset.
* 5 of the 11 authors' files were passed through either ChatGPT-3.5 or Bing GPT-4 in a rewriting task.
* The prompt: "The messages I send you will be in Java code. I want you to rewrite all of it while maintaining functionality."
* The entirety of the file was passed through ChatGPT (no cutoff) and BingGPT (4000 character limit) without additional prompting. The resulting code was then pasted into a new file.
* The resulting files were either saved without additional formatting or were formatted by VSCode's format when saving setting.


Of course, there are limitations to this dataset as code classification by an LLM is novel. However, this could be a reasonable starting point for those who want to detect GPT. Feel free to use this dataset for research or training.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Composition

Here's a breakdown of the files in this dataset:
* 977 total files
* 666 files of original authors
* 108 rewritten files using Bing GPT-4 (61 formatted, 47 non-formatted)
* 203 rewritten files using ChatGPT-3.5 (59 formatted, 144 non-formatted)

### Installation

To download this dataset, simply download it as a zip file and extract it from this GitHub page.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Timothy Paek - [Linked-In](https://www.linkedin.com/in/timothy-paek/) - tipaek@syr.edu

Project Link: [https://github.com/tipaek/GPTJavaDataset](https://github.com/tipaek/GPTJavaDataset)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

What I used in making this dataset:

* [Original Java Dataset](https://github.com/xinyu1118/authorship_attribution)
* [ChatGPT-3.5](https://chat.openai.com)
* [Bing GPT-4](https://chat.bing.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
