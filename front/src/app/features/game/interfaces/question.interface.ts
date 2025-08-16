export interface Question {
  id: number;
  text: string;
  answers: { id: number; text: string }[];
  correctAnswerId: number;
}
