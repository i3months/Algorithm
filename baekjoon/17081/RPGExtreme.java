import java.util.*;
import java.io.*;

public class RPGExtreme {

  static int N;
  static int M;
  static Object[][] grid;

  static int K = 1; // number of monster (include BOSS)
  static int L = 0; // number of box

  static int turn;

  static int hero_row = 0;
  static int hero_column = 0;

  static int hero_maxHP = 20;
  static int hero_hp = 20;
  static int hero_attack = 2;
  static int hero_defense = 2;
  static int hero_level = 1;
  static int hero_exp = 0;
  static int hero_maxEXP = 5;

  static int hero_weapon = 0;
  static int hero_armor = 0;

  static int initial_row = 0;
  static int initial_column = 0;

  static int boss_row = 0;
  static int boss_column = 0;

  static String msg = "";

  static ArrayList<String> hero_accesory = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    grid = new Object[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        char tmp = str.charAt(j);
        grid[i][j] = tmp;
        if (tmp == '@') {
          hero_row = i;
          hero_column = j;
          initial_column = j;
          initial_row = i;
        }
        if (tmp == '&') {
          K++;
        }
        if (tmp == 'B') {
          L++;
        }
        if (tmp == 'M') {
          boss_row = i;
          boss_column = j;
        }

      }
    }

    String cmd = br.readLine();

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());

      int row = Integer.parseInt(st.nextToken());
      int column = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      int attack = Integer.parseInt(st.nextToken());
      int defense = Integer.parseInt(st.nextToken());
      int maxHP = Integer.parseInt(st.nextToken());
      int exp = Integer.parseInt(st.nextToken());

      if (row == boss_row && column == boss_column) {
        grid[row - 1][column - 1] = new Boss(name, attack, defense, maxHP, exp, row - 1, column - 1);
      } else {
        grid[row - 1][column - 1] = new Monster(name, attack, defense, maxHP, exp, row - 1, column - 1);
      }
    }

    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int column = Integer.parseInt(st.nextToken());
      char kind = st.nextToken().charAt(0);
      String effect = st.nextToken();

      grid[row - 1][column - 1] = new Box(row - 1, column - 1, kind, effect);
    }

    for (int i = 0; i < cmd.length(); i++) {
      char tmp = cmd.charAt(i);

      Message qwer = move(tmp);

      boolean die_or_alive = qwer.die;
      String dying_message = qwer.message;

      if (die_or_alive == false) {
        msg = dying_message;
        break;
      }

      if (i == cmd.length() - 1 && die_or_alive == true) {
        msg = dying_message;
      }

      // logic 구현..
    }

    print(); //////////////////

  } // end of main method

  static Message move(char tmp) {

    if (tmp == 'L') {

      if ((hero_column + 1) >= 0) {

        if (grid[hero_row][hero_column - 1].getClass().getName().equals("java.lang.Character")) { // 바꿔야 될 수도..?
          char temp = (char) grid[hero_row][hero_column - 1];

          if (temp == '#') {
            if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
              if ((char) grid[hero_row][hero_column] == '^') {
                if (hero_accesory.contains("DX")) {
                  hero_hp = hero_hp - 1;
                } else {
                  hero_hp = hero_hp - 5;
                }

                if (hero_hp <= 0) {
                  if (hero_accesory.contains("RE") == false) {
                    hero_hp = 0;
                    return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
                  } else {
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                  }

                }

              }
            }
          }

          if (temp == '^') {
            hero_column = hero_column - 1;

            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }
            grid[hero_row][hero_column + 1] = '.';
          }
        }

        if (grid[hero_row][hero_column - 1].getClass().getName().equals("Box")) {
          hero_column = hero_column - 1;
          Box temp = (Box) grid[hero_row][hero_column];

          grid[hero_row][hero_column + 1] = '.';

          if (temp.kind == 'W') {
            hero_attack = hero_attack - hero_weapon;
            hero_weapon = Integer.parseInt(temp.effect);
            hero_attack = hero_attack + hero_weapon;
          }

          if (temp.kind == 'A') {
            hero_defense = hero_defense - hero_armor;
            hero_armor = Integer.parseInt(temp.effect);
            hero_defense = hero_defense + hero_armor;
          }

          if (temp.kind == 'O') {
            String effect = temp.effect;
            if (hero_accesory.contains(effect) == false) {
              if (hero_accesory.size() < 4) {
                hero_accesory.add(effect);
              }
            }
          }

        }

        if (grid[hero_row][hero_column - 1].getClass().getName().equals("Monster")) {

          Monster temp = (Monster) grid[hero_row][hero_column - 1];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_column = hero_column - 1;
                    grid[hero_row][hero_column + 1] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_column = hero_column - 1;
                    grid[hero_row][hero_column + 1] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  hero_column = hero_column - 1;
                  grid[hero_row][hero_column + 1] = '.';
                  break;
                }
                hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                    return new Message(false, asdf);
                  }

                }

              }

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                hero_column = hero_column - 1;
                grid[hero_row][hero_column + 1] = '.';
                break;
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Monster

        if (grid[hero_row][hero_column - 1].getClass().getName().equals("Boss")) {

          Boss temp = (Boss) grid[hero_row][hero_column - 1];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("HU")) {
                hero_hp = hero_maxHP;
              }
            }

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }

                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }

                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }
                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  return new Message(false, "YOU WIN!");
                }
                if (!hero_accesory.contains("HU")) {
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                }
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                    return new Message(false, asdf);
                  }

                }

              }
              // end of cnt 1

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                return new Message(false, "YOU WIN!");
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Boss

      } else if (hero_column + 1 == -1) {

        if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
          if ((char) grid[hero_row][hero_column] == '^') {
            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }

          }
        }
      }

    } // end of case L

    if (tmp == 'R') {
      if ((hero_column + 1) >= 0) {

        if (grid[hero_row][(hero_column + 1)].getClass().getName().equals("java.lang.Character")) { // 바꿔야 될 수도..?
          char temp = (char) grid[hero_row][(hero_column + 1)];

          if (temp == '#') {
            if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
              if ((char) grid[hero_row][hero_column] == '^') {
                if (hero_accesory.contains("DX")) {
                  hero_hp = hero_hp - 1;
                } else {
                  hero_hp = hero_hp - 5;
                }

                if (hero_hp <= 0) {
                  if (hero_accesory.contains("RE") == false) {
                    hero_hp = 0;
                    return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
                  } else {
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                  }

                }

              }
            }
          }

          if (temp == '^') {
            hero_column = (hero_column + 1);

            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }
            grid[hero_row][hero_column - 1] = '.';
          }
        }

        if (grid[hero_row][(hero_column + 1)].getClass().getName().equals("Box")) {
          hero_column = (hero_column + 1);
          Box temp = (Box) grid[hero_row][hero_column];

          grid[hero_row][hero_column - 1] = '.';

          if (temp.kind == 'W') {
            hero_attack = hero_attack - hero_weapon;
            hero_weapon = Integer.parseInt(temp.effect);
            hero_attack = hero_attack + hero_weapon;
          }

          if (temp.kind == 'A') {
            hero_defense = hero_defense - hero_armor;
            hero_armor = Integer.parseInt(temp.effect);
            hero_defense = hero_defense + hero_armor;
          }

          if (temp.kind == 'O') {
            String effect = temp.effect;
            if (hero_accesory.contains(effect) == false) {
              if (hero_accesory.size() < 4) {
                hero_accesory.add(effect);
              }
            }
          }

        }

        if (grid[hero_row][(hero_column + 1)].getClass().getName().equals("Monster")) {

          Monster temp = (Monster) grid[hero_row][(hero_column + 1)];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_column = (hero_column + 1);
                    grid[hero_row][hero_column - 1] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_column = (hero_column + 1);
                    grid[hero_row][hero_column - 1] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  hero_column = (hero_column + 1);
                  grid[hero_row][hero_column - 1] = '.';
                  break;
                }
                hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                    return new Message(false, asdf);
                  }

                }

              }

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                hero_column = (hero_column + 1);
                grid[hero_row][hero_column - 1] = '.';
                break;
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Monster

        if (grid[hero_row][(hero_column + 1)].getClass().getName().equals("Boss")) {

          Boss temp = (Boss) grid[hero_row][(hero_column + 1)];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("HU")) {
                hero_hp = hero_maxHP;
              }
            }

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }

                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }

                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }
                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  return new Message(false, "YOU WIN!");
                }
                if (!hero_accesory.contains("HU")) {
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                }
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                    return new Message(false, asdf);
                  }

                }

              }
              // end of cnt 1

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                return new Message(false, "YOU WIN!");
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Boss

      } else if ((hero_column + 1) == N) {

        if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
          if ((char) grid[hero_row][hero_column] == '^') {
            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }

          }
        }
      }

    } // end of case R

    if (tmp == 'U') {
      if ((hero_row - 1) >= 0) {

        if (grid[hero_row - 1][hero_column].getClass().getName().equals("java.lang.Character")) { // 바꿔야 될 수도..?
          char temp = (char) grid[hero_row - 1][hero_column];

          if (temp == '#') {
            if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
              if ((char) grid[hero_row][hero_column] == '^') {
                if (hero_accesory.contains("DX")) {
                  hero_hp = hero_hp - 1;
                } else {
                  hero_hp = hero_hp - 5;
                }

                if (hero_hp <= 0) {
                  if (hero_accesory.contains("RE") == false) {
                    hero_hp = 0;
                    return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
                  } else {
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                  }

                }

              }
            }
          }

          if (temp == '^') {
            hero_row = hero_row - 1;

            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }
            grid[hero_row + 1][hero_column] = '.';
          }
        }

        if (grid[hero_row - 1][hero_column].getClass().getName().equals("Box")) {
          hero_row = hero_row - 1;
          Box temp = (Box) grid[hero_row][hero_column];

          grid[hero_row + 1][hero_column] = '.';

          if (temp.kind == 'W') {
            hero_attack = hero_attack - hero_weapon;
            hero_weapon = Integer.parseInt(temp.effect);
            hero_attack = hero_attack + hero_weapon;
          }

          if (temp.kind == 'A') {
            hero_defense = hero_defense - hero_armor;
            hero_armor = Integer.parseInt(temp.effect);
            hero_defense = hero_defense + hero_armor;
          }

          if (temp.kind == 'O') {
            String effect = temp.effect;
            if (hero_accesory.contains(effect) == false) {
              if (hero_accesory.size() < 4) {
                hero_accesory.add(effect);
              }
            }
          }

        }

        if (grid[hero_row - 1][hero_column].getClass().getName().equals("Monster")) {

          Monster temp = (Monster) grid[hero_row - 1][hero_column];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_row = hero_row - 1;
                    grid[hero_row + 1][hero_column] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_row = hero_row - 1;
                    grid[hero_row + 1][hero_column] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  hero_row = hero_row - 1;
                  grid[hero_row + 1][hero_column] = '.';
                  break;
                }
                hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                    return new Message(false, asdf);
                  }

                }

              }

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                hero_row = hero_row - 1;
                grid[hero_row + 1][hero_column] = '.';
                break;
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Monster

        if (grid[hero_row - 1][hero_column].getClass().getName().equals("Boss")) {

          Boss temp = (Boss) grid[hero_row - 1][hero_column];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("HU")) {
                hero_hp = hero_maxHP;
              }
            }

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }

                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }

                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }
                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  return new Message(false, "YOU WIN!");
                }
                if (!hero_accesory.contains("HU")) {
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                }
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                    return new Message(false, asdf);
                  }

                }

              }
              // end of cnt 1

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                return new Message(false, "YOU WIN!");
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Boss

      } else if (hero_row - 1 == -1) {

        if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
          if ((char) grid[hero_row][hero_column] == '^') {
            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }

          }
        }
      } ////////////////////////////////////////////////////////////////////////////////// case
        ////////////////////////////////////////////////////////////////////////////////// of
        ////////////////////////////////////////////////////////////////////////////////// U

    }

    if (tmp == 'D') {

      if ((hero_row + 1) >= 0) {

        if (grid[hero_row + 1][hero_column].getClass().getName().equals("java.lang.Character")) { // 바꿔야 될 수도..?
          char temp = (char) grid[hero_row + 1][hero_column];

          if (temp == '#') {
            if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
              if ((char) grid[hero_row][hero_column] == '^') {
                if (hero_accesory.contains("DX")) {
                  hero_hp = hero_hp - 1;
                } else {
                  hero_hp = hero_hp - 5;
                }

                if (hero_hp <= 0) {
                  if (hero_accesory.contains("RE") == false) {
                    hero_hp = 0;
                    return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
                  } else {
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                  }

                }

              }
            }
          }

          if (temp == '^') {
            hero_row = hero_row + 1;

            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }
            grid[hero_row - 1][hero_column] = '.';
          }
        }

        if (grid[hero_row + 1][hero_column].getClass().getName().equals("Box")) {
          hero_row = hero_row + 1;
          Box temp = (Box) grid[hero_row][hero_column];

          grid[hero_row - 1][hero_column] = '.';

          if (temp.kind == 'W') {
            hero_attack = hero_attack - hero_weapon;
            hero_weapon = Integer.parseInt(temp.effect);
            hero_attack = hero_attack + hero_weapon;
          }

          if (temp.kind == 'A') {
            hero_defense = hero_defense - hero_armor;
            hero_armor = Integer.parseInt(temp.effect);
            hero_defense = hero_defense + hero_armor;
          }

          if (temp.kind == 'O') {
            String effect = temp.effect;
            if (hero_accesory.contains(effect) == false) {
              if (hero_accesory.size() < 4) {
                hero_accesory.add(effect);
              }
            }
          }

        }

        if (grid[hero_row + 1][hero_column].getClass().getName().equals("Monster")) {

          Monster temp = (Monster) grid[hero_row + 1][hero_column];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_row = hero_row + 1;
                    grid[hero_row - 1][hero_column] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    hero_row = hero_row + 1;
                    grid[hero_row - 1][hero_column] = '.';
                    break;
                  }
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  hero_row = hero_row + 1;
                  grid[hero_row - 1][hero_column] = '.';
                  break;
                }
                hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                    return new Message(false, asdf);
                  }

                }

              }

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                hero_row = hero_row + 1;
                grid[hero_row - 1][hero_column] = '.';
                break;
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + temp.name + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Monster

        if (grid[hero_row + 1][hero_column].getClass().getName().equals("Boss")) {

          Boss temp = (Boss) grid[hero_row + 1][hero_column];
          int cnt = 1;

          boolean chk = true;

          while (true) {

            if (cnt == 1) {
              if (hero_accesory.contains("HU")) {
                hero_hp = hero_maxHP;
              }
            }

            if (cnt == 1) {
              if (hero_accesory.contains("CO")) {
                if (hero_accesory.contains("DX")) {
                  temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }

                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }

                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                } else {
                  temp.hp = temp.hp - Math.max(1, 2 * hero_attack - temp.defense);
                  if (temp.hp <= 0) {
                    return new Message(false, "YOU WIN!");
                  }
                  if (!hero_accesory.contains("HU")) {
                    hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                  }
                  if (hero_hp <= 0) {

                    if (hero_accesory.contains("RE")) {

                      chk = false;
                      hero_accesory.remove("RE");
                      hero_hp = hero_maxHP;
                      hero_row = initial_row;
                      hero_column = initial_column;
                      break;

                    } else {
                      String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                      return new Message(false, asdf);
                    }

                  }

                }
              } else {
                temp.hp = temp.hp - Math.max(1, hero_attack - temp.defense);
                if (temp.hp <= 0) {
                  return new Message(false, "YOU WIN!");
                }
                if (!hero_accesory.contains("HU")) {
                  hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
                }
                if (hero_hp <= 0) {

                  if (hero_accesory.contains("RE")) {

                    chk = false;
                    hero_accesory.remove("RE");
                    hero_hp = hero_maxHP;
                    hero_row = initial_row;
                    hero_column = initial_column;
                    break;

                  } else {
                    String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                    return new Message(false, asdf);
                  }

                }

              }
              // end of cnt 1

            } else {
              temp.hp = temp.hp - Math.max(1, 3 * hero_attack - temp.defense);
              if (temp.hp <= 0) {
                return new Message(false, "YOU WIN!");
              }
              hero_hp = hero_hp - Math.max(1, temp.attack - hero_defense);
              if (hero_hp <= 0) {
                String asdf = "YOU HAVE BEEN KILLED BY" + " Boss" + "..";
                return new Message(false, asdf);
              }

            }

            cnt++;

          } // end of while true

          if (chk) {
            if (hero_accesory.contains("HR")) {
              hero_hp = Math.min(hero_hp + 3, hero_maxHP);
            }

            if (hero_accesory.contains("EX")) {
              hero_exp = hero_exp + (int) (temp.exp * 1.2);
            } else {
              hero_exp = hero_exp + temp.exp;
            }

            if (hero_exp >= hero_maxEXP) {
              hero_level++;
              hero_maxEXP = hero_level * 5;
              hero_defense = hero_defense + 2;
              hero_attack = hero_attack + 2;
              hero_maxHP = hero_maxHP + 5;
              hero_hp = hero_maxHP;
              hero_exp = 0;
            }
          }

        } // case of Boss

      } else if (hero_row + 1 == M) {

        if (grid[hero_row][hero_column].getClass().getName().equals("java.lang.Character")) {
          if ((char) grid[hero_row][hero_column] == '^') {
            if (hero_accesory.contains("DX")) {
              hero_hp = hero_hp - 1;
            } else {
              hero_hp = hero_hp - 5;
            }

            if (hero_hp <= 0) {
              if (hero_accesory.contains("RE") == false) {
                hero_hp = 0;
                return new Message(false, "YOU HAVE BEEN KILLED BY SPIKE TRAP..");
              } else {
                hero_accesory.remove("RE");
                hero_hp = hero_maxHP;
                hero_row = initial_row;
                hero_column = initial_column;
              }

            }

          }
        }
      } ////////////////////////////////////////////////////////////////////////////////// case

    }

    return new Message(true, "Press any key to continue.");

  }// end of move method

  static void print() {

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (i == hero_row && j == hero_column) {
          System.out.print('@');
        } else {
          if (grid[i][j].getClass().getName().equals("java.lang.Character")) {
            System.out.print((char) grid[i][j]);
          } else if (grid[i][j].getClass().getName().equals("Box")) {
            System.out.print('B');
          } else if (grid[i][j].getClass().getName().equals("Monster")) {
            System.out.print('&');
          } else if (grid[i][j].getClass().getName().equals("Boss")) {
            System.out.print('M');
          }
        }

      }
      System.out.println();
    }

    System.out.println("Passed Turns : " + turn);
    System.out.println("LV : " + hero_level);
    System.out.println("HP : " + hero_hp + "/" + hero_maxHP);
    System.out.println("ATT : " + (hero_attack - hero_weapon) + "+" + hero_weapon);
    System.out.println("DEF : " + (hero_defense - hero_armor) + "+" + hero_armor);
    System.out.println("EXP : " + hero_exp + "/" + hero_maxEXP);

  }

} // end of Main

class Box {
  int row = 0;
  int column = 0;
  char kind = ' ';
  String effect = "";

  Box(int a, int b, char c, String d) {
    row = a;
    column = b;
    kind = c;
    effect = d;
  }

} // end of class Box

class Monster {
  String name = "";
  int attack = 0;
  int defense = 0;
  int maxHP = 0;
  int hp = 0;

  int exp = 0;

  int row = 0;
  int column = 0;

  Monster(String a, int b, int c, int d, int e, int f, int g) {
    name = a;
    attack = b;
    defense = c;
    maxHP = d;
    hp = d;
    exp = e;
    row = f;
    column = g;
  }

} // end of class Monster

class Boss {
  String name = "";
  int attack = 0;
  int defense = 0;
  int maxHP = 0;
  int hp = 0;

  int exp = 0;

  int row = 0;
  int column = 0;

  Boss(String a, int b, int c, int d, int e, int f, int g) {
    name = a;
    attack = b;
    defense = c;
    maxHP = d;
    hp = d;
    exp = e;
    row = f;
    column = g;
  }

} // end of class Monster

class Message {
  boolean die = false;
  String message;

  Message(boolean a, String b) {
    die = a;
    message = b;
  }
}
