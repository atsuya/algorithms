#pragma once

#include "vertex.h"

#include <unordered_map>
#include <vector>

const Vertex* kVertexA = new Vertex("A");
const Vertex* kVertexB = new Vertex("B");
const Vertex* kVertexC = new Vertex("C");
const Vertex* kVertexD = new Vertex("D");
const Vertex* kVertexE = new Vertex("E");
const Vertex* kVertexF = new Vertex("F");
const Vertex* kVertexG = new Vertex("G");
const Vertex* kVertexH = new Vertex("H");
const Vertex* kVertexI = new Vertex("I");
const std::unordered_map<std::string, const Vertex*> kVertices{
    {kVertexA->GetName(), kVertexA}, {kVertexB->GetName(), kVertexB},
    {kVertexC->GetName(), kVertexC}, {kVertexD->GetName(), kVertexD},
    {kVertexE->GetName(), kVertexE}, {kVertexF->GetName(), kVertexF},
    {kVertexG->GetName(), kVertexG}, {kVertexH->GetName(), kVertexH},
    {kVertexI->GetName(), kVertexI}};

class Dijkstra {
 public:
  Dijkstra() = default;
  Dijkstra(const Dijkstra&) = delete;
  Dijkstra& operator=(const Dijkstra&) = delete;

  void Run(const Vertex* start, const Vertex* goal);

 private:
  void Initialize();
  std::string MinimumDistance();

  std::unordered_map<std::string, std::unordered_map<std::string, int32_t>>
      graph_;
  std::unordered_map<std::string, std::vector<std::string>> neighbors_;
  std::unordered_map<std::string, int32_t> distances_;
  std::unordered_map<std::string, std::string> previous_;
  std::unordered_map<std::string, void*> vertices_to_visit_;
};
