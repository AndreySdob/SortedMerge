package ru.netology;


import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] teams = {
                { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
                { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
                { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    public static int[] mergeAll(int[][] teams) {
        // Если команд нет, возвращаем пустой массив
        if (teams == null || teams.length == 0) {
            return new int[0];
        }

        // Начинаем с первой команды как с промежуточного результата
        int[] nationalTeam = teams[0];

        // Проходим по остальным командам и сливаем их с промежуточным результатом
        for (int i = 1; i < teams.length; i++) {
            nationalTeam = merge(nationalTeam, teams[i]);
        }

        return nationalTeam;
    }


    public int[] top(int result[]) {
        int[] nationalTeam = new int[10];
        for (int i = 0; i < nationalTeam.length; i++) {
            for (int j = result.length - 1; j > 0; j--)
                while (i <= 9) {
                    nationalTeam[i] = result[j];
                }
        }
        return nationalTeam;
    }

    public static int[] merge(int[] teamA, int[] teamB) {
        int[] result = new int[10];
        int i = 0, j = 0, k = 0;

        while (i < teamA.length && j < teamB.length && k < 10) {
            if (teamA[i] > teamB[j]) {
                result[k++] = teamA[i++];
            } else {
                result[k++] = teamB[j++];
            }
        }
        
        return result;
    }

}