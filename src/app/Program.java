package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Lesson> lessons = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Dados da %da aula:\n", i);
			System.out.print("Conteudo ou tarefa (c/t)? ");
			char type = sc.next().toLowerCase().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if(type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				lessons.add(new Video(title, url, seconds));
				System.out.println();
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				lessons.add(new Task(title, description, questionCount));
				System.out.println();
			}
		}
		int sum = 0;
		for(Lesson lesson : lessons) {
			sum += lesson.duration();
		}
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);
		sc.close();
	}

}
